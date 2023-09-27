package coutinho.santanderbootcamp.service;

import coutinho.santanderbootcamp.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);

//    User update(Long id, User userToUpdate); WIP

    void delete(Long id);
}
