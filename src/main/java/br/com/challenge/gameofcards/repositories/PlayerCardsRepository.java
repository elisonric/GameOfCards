package br.com.challenge.gameofcards.repositories;

import br.com.challenge.gameofcards.entities.PlayerCards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerCardsRepository extends CrudRepository<PlayerCards, Long> {
}
