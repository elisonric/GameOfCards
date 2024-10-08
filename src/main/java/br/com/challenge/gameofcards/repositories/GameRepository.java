package br.com.challenge.gameofcards.repositories;

import br.com.challenge.gameofcards.entities.GameEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<GameEntity, Long> {

    Optional<GameEntity> findByIdDeck(String idDeck);
}
