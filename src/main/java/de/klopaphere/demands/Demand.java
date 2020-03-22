package de.klopaphere.demands;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Demand {
  private String product;
  private String location;
}
