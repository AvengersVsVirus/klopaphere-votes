package de.klopaphere.place.model;

import java.util.Collection;
import lombok.Data;

@Data
public class OverpassResponse {
  private String version;
  private String generator;
  private Collection<OverpassElement> elements;
}
