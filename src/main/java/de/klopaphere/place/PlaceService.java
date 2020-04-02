package de.klopaphere.place;

import de.klopaphere.place.model.OverpassElement;
import de.klopaphere.place.model.OverpassResponse;
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

  private static final String QUERY_TEMPLATE =
      "[out:json];node(around:50.0,%s)[shop=supermarket]->.all;rel(bn.all);node(r)->.b;( .all; - .b; );out meta;";
  @Inject @RestClient private OverpassService overpassService;

  public CompletionStage<Collection<OverpassElement>> findNearPlace(Vote voting) {
    // map location to "place" (e.g. supermarket)
    log.debug("search for places in location {}", voting.getLocation());
    return overpassService
        .executeQuery(String.format(QUERY_TEMPLATE, voting.getLocation()))
        .thenApply(OverpassResponse::getElements);
  }
}
