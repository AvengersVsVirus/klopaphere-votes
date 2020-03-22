package de.klopaphere.voting;

import de.klopaphere.voting.model.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<VoteEntity, Long> {}
