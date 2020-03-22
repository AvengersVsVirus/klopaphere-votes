package de.klopaphere.demand;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Path("/demand")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class DemandController {

  @Inject DemandService service;

  @POST
  public Demand reportDemand(@Valid Demand demand) {
    service.processNewDemand(demand);
    return demand;
  }
}
