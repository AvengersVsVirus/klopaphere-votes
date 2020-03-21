package de.klopaphere.votes;

import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/vote")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VoteResource {

  @POST
  public Vote vote(@Valid Vote voting) {
    return Vote.builder()
        .availability(Availability.NORMAL)
        .product("Klopapier")
        .location("53.6159766,9.9022919")
        .build();
  }
}
