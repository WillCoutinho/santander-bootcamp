package coutinho.santanderbootcamp.repository;

import coutinho.santanderbootcamp.domain.model.BaseItem;
import coutinho.santanderbootcamp.domain.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
    boolean existsByCode(String code);
    boolean existsById(Long id);

    @Query("SELECT u FROM tb_feature u WHERE u.code = :code")
    BaseItem findFeatureByCode(@Param("code") String code);
}
