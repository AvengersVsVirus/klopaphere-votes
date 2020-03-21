package de.klopaphere.product;

import static java.nio.charset.StandardCharsets.UTF_8;

import de.klopaphere.votes.VoteService;
import java.io.IOException;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.io.IOUtils;

@Singleton
@Path("/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

  @Inject VoteService service;

  @GET
  public Response mockProducts() throws IOException {
    return Response.ok(
            IOUtils.toString(
                Objects.requireNonNull(
                    this.getClass().getClassLoader().getResourceAsStream("productMocks.json")),
                UTF_8))
        .build();
  }
}
