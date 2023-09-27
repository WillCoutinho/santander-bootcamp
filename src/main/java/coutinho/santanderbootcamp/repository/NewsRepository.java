package coutinho.santanderbootcamp.repository;

import coutinho.santanderbootcamp.domain.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
    boolean existsByCode(String code);
}
