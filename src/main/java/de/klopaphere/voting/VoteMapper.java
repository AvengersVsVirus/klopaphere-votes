package de.klopaphere.voting;

import de.klopaphere.config.MappingConfig;
import de.klopaphere.voting.model.Vote;
import de.klopaphere.voting.model.VoteEntity;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(config = MappingConfig.class)
public interface VoteMapper {
  Vote toDTO(VoteEntity entity);

  Collection<Vote> toDTOs(Collection<VoteEntity> entities);

  VoteEntity toEntity(Vote dto);
}
