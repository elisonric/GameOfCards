package br.com.challenge.gameofcards.repository;

import br.com.challenge.gameofcards.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
}
