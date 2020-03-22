package de.klopaphere.heatmap;

import de.klopaphere.voting.model.Vote;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@Singleton
@Slf4j
public class HeatmapService {

  @Incoming("voting-in")
  public void handleIncommingVoting(Vote voting) {
    log.info("new voting: {}", voting);
  }
}
