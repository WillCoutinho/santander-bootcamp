package coutinho.santanderbootcamp.repository;

import coutinho.santanderbootcamp.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

    boolean existsByCardNumber(String cardNumber);
}
