package de.klopaphere.heatmap;

import de.klopaphere.config.MappingConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MappingConfig.class)
public interface HeatmapEntryMapper {
  @Mapping(target = "id", ignore = true)
  HeatmapEntryEntity update(HeatmapEntry update, @MappingTarget HeatmapEntryEntity fromDatabase);
}
