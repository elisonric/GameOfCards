package br.com.challenge.gameofcards.services;

import br.com.challenge.gameofcards.entities.GameEntity;
import br.com.challenge.gameofcards.entities.GameWinner;
import br.com.challenge.gameofcards.entities.PlayerCards;
import br.com.challenge.gameofcards.models.PlayerDTO;
import br.com.challenge.gameofcards.repositories.GameWinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameWinnerService {

    @Autowired
    private GameWinnerRepository gameWinnerRepository;

    public List<PlayerDTO> calculateWinners(List<PlayerCards> playerCards) {
        Integer maxTotalValue = playerCards.stream()
                .map(PlayerCards::getTotalValue)
                .max(Integer::compareTo)
                .orElse(null);

        List<PlayerCards> winners = playerCards.stream()
                .filter(player -> player.getTotalValue().equals(maxTotalValue))
                .toList();

        return winners.stream()
                .map(PlayerDTO::convertToPlayerDTO).toList();

    }

    public void saveWinners(List<PlayerDTO> winners, GameEntity gameEntity) {
        List<GameWinner> gameWinners = new ArrayList<>();
        for (PlayerDTO winner : winners) {
            gameWinners.add(new GameWinner(gameEntity.getId(), winner.getId()));
        }
        gameWinnerRepository.saveAll(gameWinners);
    }

    public List<GameWinner> findIdPlayersWinnersOfGame(Long idGame) {
        return gameWinnerRepository.findByIdGame(idGame);
    }
}
