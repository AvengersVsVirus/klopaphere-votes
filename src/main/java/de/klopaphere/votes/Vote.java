package de.klopaphere.votes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vote {
  private Long id;
  private String product;
  private String location;
  private Availability availability;
}
