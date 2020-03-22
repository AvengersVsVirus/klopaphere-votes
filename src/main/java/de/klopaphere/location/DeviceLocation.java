package de.klopaphere.location;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeviceLocation {
  private String location;
  private String deviceToken;
}
