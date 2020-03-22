package de.klopaphere.heatmap;

import de.klopaphere.voting.model.Availability;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HeatmapEntry {
  private String product;
  private String location;
  private Availability availability;
}
