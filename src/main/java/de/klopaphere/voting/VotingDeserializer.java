package de.klopaphere.voting;

import de.klopaphere.voting.model.Vote;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class VotingDeserializer extends ObjectMapperDeserializer<Vote> {
  public VotingDeserializer() {
    super(Vote.class);
  }
}
