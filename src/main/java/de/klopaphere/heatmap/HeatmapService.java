package de.klopaphere.heatmap;

import de.klopaphere.voting.model.Vote;
import java.util.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.context.ManagedExecutor;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@Singleton
@Slf4j
public class HeatmapService {

  @Inject HeatmapRepository repository;
  @Inject HeatmapEntryMapper mapper;
  @Inject PlaceService placeService;
  @Inject ManagedExecutor managedExecutor;

  @Incoming("voting-in")
  public void handleIncommingVoting(Vote voting) {
    log.info("Incoming Voting: {}", voting);
    HeatmapEntry entry =
        placeService
            .findNearPlace(voting)
            .map(
                nearestShop -> {
                  // found supermarket or drugstore
                  log.info(
                      "Voting from a known shop {}: {}",
                      nearestShop.name,
                      nearestShop.formattedAddress);
                  return HeatmapEntry.builder()
                      .product(voting.getProduct())
                      .geographicCoordinate(nearestShop.geometry.location.toUrlValue())
                      .locationDescription(nearestShop.name)
                      .locationFormattedAddress(nearestShop.formattedAddress)
                      .locationIcon(nearestShop.icon.toExternalForm())
                      .locationGooglePlaceId(nearestShop.placeId);
                })
            .orElse(
                // voting is not from a supermarket or a drugstore
                HeatmapEntry.builder()
                    .product(voting.getProduct())
                    .geographicCoordinate(voting.getLocation()))
            .averageAvailability(voting.getAvailability())
            .build();

    managedExecutor.runAsync(
        () -> {
          // find earlier voting for this "place"
          Optional<HeatmapEntryEntity> maybeEarlierEntry =
              repository.findByProductAndGeographicCoordinate(
                  entry.getProduct(), entry.getGeographicCoordinate());

          // create new entry or update earlier one
          HeatmapEntryEntity update =
              mapper.update(entry, maybeEarlierEntry.orElse(new HeatmapEntryEntity()));
          HeatmapEntryEntity savedEntry = repository.save(update);
          log.debug("persist new / updated heatmap-entry: {}", savedEntry);
        });
  }
}
