package de.klopaphere.voting.model;

import java.util.Collection;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VoteCollection {
  private Collection<Vote> votes;
}
