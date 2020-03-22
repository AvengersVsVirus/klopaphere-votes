package de.klopaphere.voting;

import de.klopaphere.voting.model.Vote;
import de.klopaphere.voting.model.VoteCollection;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Singleton
@Path("/vote")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class VoteController {

  @Inject VoteService service;
  @Inject VoteMapper mapper;

  @Inject
  @Channel("voting")
  Emitter<Vote> emitter;

  @POST
  public Vote vote(@Valid Vote voting) {
    Vote createdVoting = mapper.toDTO(service.createVote(mapper.toEntity(voting)));
    emitter.send(createdVoting);
    return createdVoting;
  }

  @GET
  public VoteCollection getAllVotes() {
    return VoteCollection.builder().votes(mapper.toDTOs(service.getAllVotes())).build();
  }
}
