package de.klopaphere.voting;

import de.klopaphere.voting.model.VoteEntity;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class VoteService {

  @Inject VoteRepository repository;

  @Transactional
  public VoteEntity createVote(VoteEntity voting) {
    repository.persist(voting);
    return voting;
  }

  public Collection<VoteEntity> getAllVotes() {
    return repository.findAll().list();
  }
}
