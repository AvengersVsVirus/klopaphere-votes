package de.klopaphere.votes;

import de.klopaphere.votes.model.Vote;
import de.klopaphere.votes.model.VoteCollection;
import de.klopaphere.votes.model.VoteEntity;
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
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@Singleton
@Path("/vote")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class VoteController {

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

  @Outgoing("voting")
  @Incoming("new-votes")
  public Vote pushToKafka(VoteEntity voting) {
    return mapper.toDTO(voting);
  }

  @Incoming("voting-in")
  public void logKafkaTopic(Vote voting) {
    log.info("new voting on kafka topic: {}", voting);
  }
}
