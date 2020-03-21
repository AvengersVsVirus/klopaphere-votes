package de.klopaphere.votes;

import java.util.Collection;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VoteCollection {
  private Collection<Vote> votes;
}
