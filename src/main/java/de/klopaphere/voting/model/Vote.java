package de.klopaphere.voting.model;

import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vote {
  private Long id;
  private String product;
  private String location;
  private Availability availability;
  private OffsetDateTime creationDate;
}
