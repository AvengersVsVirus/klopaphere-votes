package de.klopaphere.heatmap;

import de.klopaphere.place.PlaceService;
import de.klopaphere.voting.model.Vote;
import java.util.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@Singleton
@Slf4j
public class HeatmapService {

  @Inject HeatmapRepository repository;
  @Inject HeatmapEntryMapper mapper;
  @Inject PlaceService placeService;

  @Incoming("voting-in")
  public void handleIncomingVoting(Vote voting) {
    log.debug("Incoming Voting: {}", voting);

    placeService
        .findNearPlace(voting)
        .thenApply(
            overpassElements ->
                overpassElements.stream()
                    .findFirst()
                    .map(
                        nearestShop -> {
                          // found supermarket or drugstore
                          log.info("Voting from a known shop {}", nearestShop.getTags().getName());
                          return HeatmapEntry.builder()
                              .product(voting.getProduct())
                              .geographicCoordinate(
                                  nearestShop.getLat() + "," + nearestShop.getLon())
                              .locationDescription(nearestShop.getTags().getName())
                              .locationOpenStreetMapUid(nearestShop.getUid());
                        })
                    .orElse(
                        // voting is not from a supermarket or a drugstore
                        HeatmapEntry.builder()
                            .product(voting.getProduct())
                            .geographicCoordinate(voting.getLocation()))
                    .averageAvailability(voting.getAvailability())
                    .build())
        .thenAccept(this::createOrUpdate);
  }

  @Transactional
  public void createOrUpdate(HeatmapEntry entry) {
    // find earlier voting for this "place"
    Optional<HeatmapEntryEntity> maybeEarlierEntry =
        repository.findByProductAndGeographicCoordinate(
            entry.getProduct(), entry.getGeographicCoordinate());

    log.debug(
        "found earlier entry for product '{}' at location '{}'? {}",
        entry.getProduct(),
        entry.getGeographicCoordinate(),
        maybeEarlierEntry.isPresent());

    // create new entry or update earlier one
    HeatmapEntryEntity update =
        mapper.update(entry, maybeEarlierEntry.orElse(new HeatmapEntryEntity()));
    repository.persist(update);
    log.debug("persist new / updated heatmap-entry: {}", update);
  }
}
