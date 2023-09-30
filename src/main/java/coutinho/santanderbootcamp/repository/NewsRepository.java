package coutinho.santanderbootcamp.repository;

import coutinho.santanderbootcamp.domain.model.BaseItem;
import coutinho.santanderbootcamp.domain.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    boolean existsNewsByCode(String code);
    boolean existsNewsById(Long id);

    @Query("SELECT u FROM tb_news u WHERE u.code = :code")
    BaseItem findNewsByCode(@Param("code") String code);
}
