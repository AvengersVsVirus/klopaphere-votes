package de.klopaphere.place;

import de.klopaphere.place.model.OverpassResponse;
import java.util.concurrent.CompletionStage;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "overpass-api")
public interface OverpassService {
  @POST
  @Produces("application/json")
  CompletionStage<OverpassResponse> executeQuery(String query);
}
