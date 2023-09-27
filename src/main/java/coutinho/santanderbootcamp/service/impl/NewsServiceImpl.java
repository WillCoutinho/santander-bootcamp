package coutinho.santanderbootcamp.service.impl;

import coutinho.santanderbootcamp.domain.model.BaseItem;
import coutinho.santanderbootcamp.domain.model.News;
import coutinho.santanderbootcamp.repository.NewsRepository;
import coutinho.santanderbootcamp.service.BaseService;
import org.springframework.stereotype.Service;

import static coutinho.santanderbootcamp.service.validation.BusinessRulesValidation.*;

@Service
public class NewsServiceImpl implements BaseService {

    private final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public News findById(Long id) {
        checkNewsExistsById(newsRepository, id);
        return newsRepository.findById(id).get();
    }

    @Override
    public News findByCode(String code) {
        checkNewsCodeExists(newsRepository, code);
        return (News) newsRepository.findNewsByCode(code);
    }

    @Override
    public News create(BaseItem news) {
        return newsRepository.save((News) news);
    }
}
