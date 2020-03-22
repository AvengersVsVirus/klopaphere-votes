package de.klopaphere.heatmap;

import de.klopaphere.voting.model.Availability;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class HeatmapEntry {
  private String product;
  private String locationDescription;
  private String geographicCoordinate;
  private Availability averageAvailability;
  private OffsetDateTime latestUpdate;
}
