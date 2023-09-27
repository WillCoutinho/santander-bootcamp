package coutinho.santanderbootcamp.service.impl;

import coutinho.santanderbootcamp.domain.model.BaseItem;
import coutinho.santanderbootcamp.domain.model.Feature;
import coutinho.santanderbootcamp.repository.FeatureRepository;
import coutinho.santanderbootcamp.service.BaseService;
import org.springframework.stereotype.Service;

import static coutinho.santanderbootcamp.service.validation.BusinessRulesValidation.*;

@Service
public class FeatureServiceImpl implements BaseService {

    private final FeatureRepository featureRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }


    @Override
    public Feature findById(Long id) {
        checkFeatureExistsById(featureRepository, id);
        return featureRepository.findById(id).get();
    }

    @Override
    public Feature findByCode(String code) {
        checkFeatureCodeExists(featureRepository, code);
        return (Feature) featureRepository.findFeatureByCode(code);
    }

    @Override
    public Feature create(BaseItem feature) {
        return featureRepository.save((Feature) feature);
    }
}
