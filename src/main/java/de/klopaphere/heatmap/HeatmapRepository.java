package de.klopaphere.heatmap;

import java.util.Collection;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeatmapRepository extends JpaRepository<HeatmapEntryEntity, Long> {
  Optional<HeatmapEntryEntity> findByProductAndGeographicCoordinate(
      String product, String geographicCoordinate);

  Collection<HeatmapEntryEntity> findByProduct(String product);
}
