package de.klopaphere.voting;

import de.klopaphere.voting.model.VoteEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VoteRepository implements PanacheRepository<VoteEntity> {}
