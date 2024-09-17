package br.com.challenge.gameofcards.repositories;

import br.com.challenge.gameofcards.entities.PlayerCards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerCardsRepository extends CrudRepository<PlayerCards, Long> {

    PlayerCards findByIdPlayer(Long idPlayer);
}
