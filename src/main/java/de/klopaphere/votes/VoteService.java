package de.klopaphere.votes;

import de.klopaphere.votes.model.VoteEntity;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Singleton
public class VoteService {

  @Inject VoteRepository repository;

  @Inject
  @Channel("new-votes")
  Emitter<VoteEntity> emitter;

  public VoteEntity createVote(VoteEntity voting) {
    VoteEntity newVoting = repository.save(voting);
    emitter.send(newVoting);
    return newVoting;
  }

  public Collection<VoteEntity> getAllVotes() {
    return repository.findAll();
  }
}
