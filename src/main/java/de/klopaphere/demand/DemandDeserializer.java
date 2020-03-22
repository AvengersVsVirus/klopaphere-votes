package de.klopaphere.demand;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class DemandDeserializer extends ObjectMapperDeserializer<Demand> {
  public DemandDeserializer() {
    super(Demand.class);
  }
}
