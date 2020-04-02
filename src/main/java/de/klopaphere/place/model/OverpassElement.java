package de.klopaphere.place.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.ZonedDateTime;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OverpassElement {
  private String type;
  private Long id;
  private float lat;
  private float lon;
  private ZonedDateTime timestamp;
  private String version;
  private String changeset;
  private String user;
  private String uid;
  private OverpassTags tags;
}
