package br.com.challenge.gameofcards.repositories;

import br.com.challenge.gameofcards.entities.GameWinner;
import br.com.challenge.gameofcards.entities.ids.GameWinnerId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameWinnerRepository extends CrudRepository<GameWinner, GameWinnerId> {
}
