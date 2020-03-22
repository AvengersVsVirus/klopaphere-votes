package de.klopaphere.heatmap;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import de.klopaphere.voting.model.Vote;
import java.io.IOException;
import java.util.Optional;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Singleton
@Slf4j
public class PlaceService {

  public static final int NEARBY_RADIUS_METERS = 50;

  @ConfigProperty(name = "klopaphere.google.api.key")
  private String apiKey;

  public Optional<PlacesSearchResult> findNearPlace(Vote voting) {
    // map location to "place" (e.g. supermarket)
    String[] latlong = voting.getLocation().split(",");
    double latitude = Double.parseDouble(latlong[0]);
    double longitude = Double.parseDouble(latlong[1]);
    return searchForPlaces(latitude, longitude);
  }

  private Optional<PlacesSearchResult> searchForPlaces(double latitude, double longitude) {
    try {
      PlacesSearchResponse searchResponse =
          PlacesApi.nearbySearchQuery(
                  new GeoApiContext.Builder().apiKey(apiKey).build(),
                  new LatLng(latitude, longitude))
              .radius(NEARBY_RADIUS_METERS)
              .type(PlaceType.DRUGSTORE)
              .type(PlaceType.SUPERMARKET)
              .await();
      return searchResponse.results.length > 0
          ? Optional.of(searchResponse.results[0])
          : Optional.empty();
    } catch (ApiException | InterruptedException | IOException e) {
      log.warn(e.getMessage());
    }
    return Optional.empty();
  }
}
