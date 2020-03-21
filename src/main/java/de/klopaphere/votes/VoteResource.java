package de.klopaphere.votes;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/vote")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VoteResource {

  @Inject VoteService service;
  @Inject VoteMapper mapper;

  @POST
  public Vote vote(@Valid Vote voting) {
    return mapper.toDTO(service.createVote(mapper.toEntity(voting)));
  }

  @GET
  public VoteCollection getAllVotes() {
    return VoteCollection.builder().votes(mapper.toDTOs(service.getAllVotes())).build();
  }
}
