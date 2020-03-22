package de.klopaphere.heatmap;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class HeatmapEntryDeserializer extends ObjectMapperDeserializer<HeatmapEntry> {
  public HeatmapEntryDeserializer() {
    super(HeatmapEntry.class);
  }
}
