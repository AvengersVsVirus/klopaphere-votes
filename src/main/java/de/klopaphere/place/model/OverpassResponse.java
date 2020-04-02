package de.klopaphere.place.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Collection;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OverpassResponse {
  private String version;
  private String generator;
  private Collection<OverpassElement> elements;
}
