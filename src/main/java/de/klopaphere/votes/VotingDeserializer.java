package de.klopaphere.votes;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class VotingDeserializer extends ObjectMapperDeserializer<Vote> {
  public VotingDeserializer() {
    super(Vote.class);
  }
}
