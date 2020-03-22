package de.klopaphere.heatmap;

import java.util.Collection;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Heatmap {
  private Collection<HeatmapEntry> entries;
}
