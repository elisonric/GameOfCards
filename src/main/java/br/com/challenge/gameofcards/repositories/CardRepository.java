package br.com.challenge.gameofcards.repositories;

import br.com.challenge.gameofcards.entities.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
}
