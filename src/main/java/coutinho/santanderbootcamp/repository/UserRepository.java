package coutinho.santanderbootcamp.repository;

import coutinho.santanderbootcamp.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //O Spring já entende que exists by é para fazer um Join e validar se existe algo com o valor informado como parâmetro
    boolean existsByAccountNumber(String accountNumber);

}
