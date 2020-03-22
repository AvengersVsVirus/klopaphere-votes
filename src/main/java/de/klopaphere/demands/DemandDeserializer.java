package de.klopaphere.demands;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class DemandDeserializer extends ObjectMapperDeserializer<Demand> {
  public DemandDeserializer() {
    super(Demand.class);
  }
}
