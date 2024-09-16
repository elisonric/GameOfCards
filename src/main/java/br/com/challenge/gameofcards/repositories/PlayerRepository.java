package br.com.challenge.gameofcards.repositories;

import br.com.challenge.gameofcards.entities.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
}
