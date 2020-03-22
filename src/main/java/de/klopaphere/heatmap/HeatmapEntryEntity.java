package de.klopaphere.heatmap;

import de.klopaphere.voting.model.Availability;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "heatmap_entry")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeatmapEntryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "product")
  private String product;

  @Column(name = "location_description")
  private String locationDescription;

  @Column(name = "location_formatted_address")
  private String locationFormattedAddress;

  @Column(name = "location_icon")
  private String locationIcon;

  @Column(name = "location_google_place_id")
  private String locationGooglePlaceId;

  @Column(name = "geographic_coordinate")
  private String geographicCoordinate;

  @Column(name = "average_availability")
  @Enumerated(EnumType.STRING)
  private Availability averageAvailability;

  @Column(name = "latest_update")
  private OffsetDateTime latestUpdate;

  @PrePersist
  @PreUpdate
  protected void update() {
    latestUpdate = OffsetDateTime.now();
  }
}
