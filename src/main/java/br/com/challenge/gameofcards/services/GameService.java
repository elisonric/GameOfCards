package br.com.challenge.gameofcards.services;

import br.com.challenge.gameofcards.entities.PlayerCards;
import br.com.challenge.gameofcards.repositories.GameRepository;
import br.com.challenge.gameofcards.entities.GameEntity;
import br.com.challenge.gameofcards.entities.Player;
import br.com.challenge.gameofcards.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private static final Logger log = LoggerFactory.getLogger(GameService.class);

    private static final Integer NUMBER_CARDS_PER_DECK = 52;

    @Autowired
    private DeckApiService deckApiService;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerCardsService playerCardsService;

    @Autowired
    private GameWinnerService gameWinnerService;

    public GameResponse start(GamePayload gamePayload) {
        log.info("Iniciando o Jogo");


        DeckApiResponseModel deck = deckApiService.createDeck(getNumberOfDecksNeeded(gamePayload.getNumberCardsPerPlayer(), gamePayload.getNumberPlayers()));
        log.info("Deck Criado id: {}", deck.getIdDeck());

        GameEntity gameEntity = saveGame(new GameEntity(deck.getIdDeck(), gamePayload.getNumberPlayers()));
        List<Player> playerList = playerService.createPlayers(gameEntity.getId(), gamePayload.getNumberPlayers());
        playerService.saveAll(playerList);
        List<PlayerCards> playerCards = playerCardsService.distributeCards(gameEntity.getIdDeck(), gamePayload.getNumberCardsPerPlayer(), playerList);
        playerCardsService.savePlayerCards(playerCards);
        List<PlayerDTO> winners = gameWinnerService.calculateWinners(playerCards);
        gameWinnerService.saveWinners(winners, gameEntity);

        playerService.mergeNamePlayers(winners, playerList);

        return new GameResponse(deck.getIdDeck(), winners);
    }

    private Integer getNumberOfDecksNeeded(Integer numberCardsPerPlayer, Integer numberPlayers) {
        Integer defaultNumberDecks = 1;
        while((numberCardsPerPlayer * numberPlayers) > (defaultNumberDecks * NUMBER_CARDS_PER_DECK)) {
            defaultNumberDecks++;
        }
        return defaultNumberDecks;
    }

    private GameEntity saveGame(GameEntity gameEntity) {
        return gameRepository.save(gameEntity);
    }

}
