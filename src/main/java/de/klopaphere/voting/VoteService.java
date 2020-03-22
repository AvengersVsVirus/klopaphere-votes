package de.klopaphere.voting;

import de.klopaphere.voting.model.VoteEntity;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class VoteService {

  @Inject VoteRepository repository;

  public VoteEntity createVote(VoteEntity voting) {
    return repository.save(voting);
  }

  public Collection<VoteEntity> getAllVotes() {
    return repository.findAll();
  }
}
