package de.klopaphere.config;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class OffsetDateTimeConverterProvider implements ParamConverterProvider {
  @Override
  public <T> ParamConverter<T> getConverter(Class<T> aClass, Type type, Annotation[] annotations) {
    if (!OffsetDateTime.class.equals(aClass)) return null;
    return (ParamConverter<T>) new OffsetDateTimeConverter();
  }
}
