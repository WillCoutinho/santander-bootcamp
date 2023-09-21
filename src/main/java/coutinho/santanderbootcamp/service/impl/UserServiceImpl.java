package coutinho.santanderbootcamp.service.impl;

import coutinho.santanderbootcamp.domain.model.User;
import coutinho.santanderbootcamp.repository.UserRepository;
import coutinho.santanderbootcamp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * Utilizamos um pacote de implementação + interface para expor somente as assinaturas necessárias para o serviço
 * Com isso, chama-se a interface como uma "fronteira" entre as camadas (encapsulamento)
 * Construtor: foi utilizado um construtor que recebe o UserRepository para inicializá-lo na camada Service.
 * Fazendo isso, o Spring entende que para criar esse Serviço ele deve injetar o Repository
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        //TODO: create an ExceptionHandler class with Business message
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        //TODO: create class with these IFs as asserts methods
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("This User ID already exists");
        }
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This account number already exists");
        }
        return userRepository.save(userToCreate);
    }
}
