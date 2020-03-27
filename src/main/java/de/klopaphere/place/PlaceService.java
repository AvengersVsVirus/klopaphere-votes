package de.klopaphere.place;

import de.klopaphere.place.model.OverpassElement;
import de.klopaphere.voting.model.Vote;
import java.util.Collection;
import java.util.concurrent.CompletionStage;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Singleton
@Slf4j
public class PlaceService {

  private final String queryTemplate =
      "[out:json];node(around:50.0,53.62955,9.92993)[shop=supermarket]->.all;rel(bn.all);node(r)->.b;( .all; - .b; );out meta;";
  @Inject @RestClient private OverpassService overpassService;

  public CompletionStage<Collection<OverpassElement>> findNearPlace(Vote voting) {
    // map location to "place" (e.g. supermarket)
    return searchForPlaces(voting.getLocation());
  }

  private CompletionStage<Collection<OverpassElement>> searchForPlaces(String location) {
    return overpassService
        .executeQuery(queryTemplate)
        .handleAsync((overpassResponse, throwable) -> overpassResponse.getElements());
  }
}
