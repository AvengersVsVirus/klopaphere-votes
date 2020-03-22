package de.klopaphere.heatmap;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Path("/heatmap")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class HeatmapController {

  @GET
  @Path("/{location}/{product}")
  public Heatmap getHeatmap(
      @PathParam("location") String location, @PathParam("product") String product) {
    // Find all Heatmap-Entries for given product in an area near given location
    return Heatmap.builder().build();
  }
}
