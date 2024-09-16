package br.com.challenge.gameofcards.repository;

import br.com.challenge.gameofcards.entity.PlayerCards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerCardsRepository extends CrudRepository<PlayerCards, Long> {
}
