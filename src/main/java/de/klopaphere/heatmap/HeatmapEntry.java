package de.klopaphere.heatmap;

import de.klopaphere.voting.model.Availability;
import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HeatmapEntry {
  private String product;
  private String locationDescription;
  private String locationFormattedAddress;
  private String locationIcon;
  private String locationGooglePlaceId;
  private String geographicCoordinate;
  private Availability averageAvailability;
  private OffsetDateTime latestUpdate;
}
