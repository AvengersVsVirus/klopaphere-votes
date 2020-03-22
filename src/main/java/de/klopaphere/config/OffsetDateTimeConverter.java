package de.klopaphere.config;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;

import java.time.OffsetDateTime;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.Provider;

@Provider
public class OffsetDateTimeConverter implements ParamConverter<OffsetDateTime> {

  public OffsetDateTime fromString(String str) {
    return OffsetDateTime.parse(str, ISO_OFFSET_DATE_TIME);
  }

  public String toString(OffsetDateTime value) {
    return value.toString();
  }
}
