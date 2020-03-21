package de.klopaphere.votes;

import de.klopaphere.config.MappingConfig;
import java.util.Collection;

import de.klopaphere.votes.model.Vote;
import de.klopaphere.votes.model.VoteEntity;
import org.mapstruct.Mapper;

@Mapper(config = MappingConfig.class)
public interface VoteMapper {
  Vote toDTO(VoteEntity entity);

  Collection<Vote> toDTOs(Collection<VoteEntity> entities);

  VoteEntity toEntity(Vote dto);
}
