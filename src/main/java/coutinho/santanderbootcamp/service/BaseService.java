package coutinho.santanderbootcamp.service;

import coutinho.santanderbootcamp.domain.model.BaseItem;
import coutinho.santanderbootcamp.domain.model.Feature;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BaseService {
    BaseItem findById(Long id);

    BaseItem create(BaseItem create);

    BaseItem delete(Long id);

    BaseItem findByCode(String code);
}
