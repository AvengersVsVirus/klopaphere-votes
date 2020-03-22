package de.klopaphere.demand;

import javax.inject.Inject;
import javax.inject.Singleton;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Singleton
public class DemandService {

  @Inject
  @Channel("demand")
  Emitter<Demand> emitter;

  public void processNewDemand(Demand demand) {
    emitter.send(demand);
  }
}
