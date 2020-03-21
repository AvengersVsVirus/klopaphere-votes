package de.klopaphere.votes;

import de.klopaphere.votes.model.Vote;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class VotingDeserializer extends ObjectMapperDeserializer<Vote> {
  public VotingDeserializer() {
    super(Vote.class);
  }
}
