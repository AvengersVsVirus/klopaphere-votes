package de.klopaphere.location;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class DeviceLocationDeserializer extends ObjectMapperDeserializer<DeviceLocation> {
  public DeviceLocationDeserializer() {
    super(DeviceLocation.class);
  }
}
