package de.klopaphere.heatmap;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.Collection;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HeatmapRepository implements PanacheRepository<HeatmapEntryEntity> {
  Optional<HeatmapEntryEntity> findByProductAndGeographicCoordinate(
      String product, String geographicCoordinate) {
    return find("product = ?1 and geographicCoordinate = ?2", product, geographicCoordinate)
        .singleResultOptional();
  }

  Collection<HeatmapEntryEntity> findByProduct(String product) {
    return find("product", product).list();
  }
}
