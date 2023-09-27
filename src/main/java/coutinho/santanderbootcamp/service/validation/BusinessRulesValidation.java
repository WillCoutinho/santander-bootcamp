package coutinho.santanderbootcamp.service.validation;

import coutinho.santanderbootcamp.domain.model.BaseItem;
import coutinho.santanderbootcamp.domain.model.Feature;
import coutinho.santanderbootcamp.repository.CardRepository;
import coutinho.santanderbootcamp.repository.FeatureRepository;
import coutinho.santanderbootcamp.repository.NewsRepository;
import coutinho.santanderbootcamp.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

import static coutinho.santanderbootcamp.controller.exception.ExceptionMessages.*;

public final class BusinessRulesValidation {

    public static Boolean isIdNull(Long id) {
        return id == null;
    }

    public static void checkUniqueIdRule(UserRepository userRepository, Long id) {
        if (!isIdNull(id) && userRepository.existsById(id)) {
            throw new IllegalArgumentException(USER_ID_ALREADY_EXISTS.getDescription());
        }
    }

    public static void checkUserExistsById(UserRepository userRepository, Long id) {
        if (!isIdNull(id) && !userRepository.existsById(id)) {
            throw new NoSuchElementException(USER_NOT_FOUND_BY_ID.getDescription());
        }
    }

    public static void checkUniqueAccountRule(UserRepository userRepository, String accountNumber) {
        if (userRepository.existsByAccountNumber(accountNumber)) {
            throw new IllegalArgumentException(ACCOUNT_ALREADY_EXISTS.getDescription());
        }
    }

    public static void checkUniqueCardNumber(CardRepository cardRepository, String cardNumber) {
        if (cardRepository.existsByCardNumber(cardNumber)) {
            throw new IllegalArgumentException(CARD_NUMBER_ALREADY_EXISTS.getDescription());
        }
    }

    public static void checkFeatureCodeListExists(FeatureRepository featureRepository, List<String> featuresCodes) {
        for (String code : featuresCodes) {
            if (!featureRepository.existsByCode(code)) {
                throw new IllegalArgumentException(FEATURE_NOT_FOUND.getDescription() + ": " + code);
            }
        }
    }

    public static void checkFeatureCodeExists(FeatureRepository featureRepository, String code) {
        if (!featureRepository.existsByCode(code)) {
            throw new NoSuchElementException(FEATURE_NOT_FOUND.getDescription() + ": " + code);
        }
    }

    public static void checkFeatureExistsById(FeatureRepository featureRepository, Long id) {
        if (!isIdNull(id) && !featureRepository.existsById(id)) {
            throw new NoSuchElementException(FEATURE_NOT_FOUND_BY_ID.getDescription());
        }
    }

    public static void checkNewsCodeExists(NewsRepository newsRepository, List<String> newsCodes) {
        for (String code : newsCodes) {
            if (!newsRepository.existsByCode(code)) {
                throw new IllegalArgumentException(NEWS_NOT_FOUND.getDescription() + ": " + code);
            }
        }
    }
}
