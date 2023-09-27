package coutinho.santanderbootcamp.service.impl;

import coutinho.santanderbootcamp.domain.model.BaseItem;
import coutinho.santanderbootcamp.domain.model.Feature;
import coutinho.santanderbootcamp.repository.FeatureRepository;
import coutinho.santanderbootcamp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static coutinho.santanderbootcamp.service.validation.BusinessRulesValidation.*;

@Service
public class FeatureServiceImpl implements BaseService {
    @Autowired
    private FeatureRepository featureRepository;

    @Override
    public BaseItem findById(Long id) {
        checkFeatureExistsById(featureRepository, id);
        return featureRepository.findById(id).get();
    }

    @Override
    public BaseItem findByCode(String code) {
        checkFeatureCodeExists(featureRepository, code);
        return featureRepository.findFeatureByCode(code);
    }

    @Override
    public BaseItem create(BaseItem feature) {
//        checkFeatureCodeExists(featureRepository, feature.getCode());
//        bankFeatureBusinessRuleValidation(featureRepository, feature);
        return featureRepository.save((Feature) feature);
    }

    @Override
    public BaseItem delete(Long id) {
        return null;
    }
}
