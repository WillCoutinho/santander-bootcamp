package coutinho.santanderbootcamp.service.impl;

import coutinho.santanderbootcamp.domain.model.User;
import coutinho.santanderbootcamp.repository.CardRepository;
import coutinho.santanderbootcamp.repository.FeatureRepository;
import coutinho.santanderbootcamp.repository.NewsRepository;
import coutinho.santanderbootcamp.repository.UserRepository;
import coutinho.santanderbootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static coutinho.santanderbootcamp.service.validation.BusinessRulesValidation.*;

/**
 * Utilizamos um pacote de implementação + interface para expor somente as assinaturas necessárias para o serviço
 * Com isso, chama-se a interface como uma "fronteira" entre as camadas (encapsulamento)
 * Construtor: foi utilizado um construtor que recebe o UserRepository para inicializá-lo na camada Service.
 * Fazendo isso, o Spring entende que para criar esse Serviço ele deve injetar o Repository
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FeatureRepository featureRepository;
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private CardRepository cardRepository;


    @Override
    public User findById(Long id) {
        checkUserExistsById(userRepository, id);
        return userRepository.findById(id).get();
    }

    @Override
    public User create(User userToCreate) {
        checkUniqueIdRule(userRepository, userToCreate.getId());
        checkUniqueAccountRule(userRepository, userToCreate.getAccount().getNumber());
        checkUniqueCardNumber(cardRepository, userToCreate.getCard().getCardNumber());
        checkFeatureCodeListExists(featureRepository, userToCreate.getFeatures());
        checkNewsCodeExists(newsRepository, userToCreate.getNews());
        return userRepository.save(userToCreate);
    }

    @Override
    public void delete(Long id) {
        checkUserExistsById(userRepository, id);
        User user = userRepository.getReferenceById(id);
        userRepository.delete(user);
    }


//    @Override WIP
//    public User update(Long id, User userToUpdate) {
//        checkUserExistsById(userRepository, userToUpdate.getId());
//        checkFeatureCodeExists(featureRepository, userToUpdate.getFeatures());
//        checkNewsCodeExists(newsRepository, userToUpdate.getNews());
//        return userRepository.save(userToUpdate);
//    }
}
