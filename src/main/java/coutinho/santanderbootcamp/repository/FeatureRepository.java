package coutinho.santanderbootcamp.repository;

import coutinho.santanderbootcamp.domain.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
    boolean existsByCode(String code);
}
