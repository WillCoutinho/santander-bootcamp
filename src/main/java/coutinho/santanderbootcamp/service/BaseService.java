package coutinho.santanderbootcamp.service;

import coutinho.santanderbootcamp.domain.model.BaseItem;

public interface BaseService {
    BaseItem findById(Long id);

    BaseItem create(BaseItem create);

    BaseItem findByCode(String code);
}
