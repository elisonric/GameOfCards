package br.com.challenge.gameofcards.services;

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

    public GameResponse start(GamePayload gamePayload) {
        log.info("Iniciando o Jogo");


        DeckApiResponseModel deck = deckApiService.createDeck(getNumberOfDecksNeeded(gamePayload.getNumberCardsPerPlayer(), gamePayload.getNumberPlayers()));
        log.info("Deck Criado id: {}", deck.getIdDeck());

        GameEntity gameEntity = saveGame(new GameEntity(deck.getIdDeck(), gamePayload.getNumberPlayers()));
        List<Player> playerList = playerService.createAndSavePlayers(gameEntity.getId(), gamePayload.getNumberPlayers());
        playerCardsService.distributeCards(gameEntity.getIdDeck(), gamePayload.getNumberCardsPerPlayer(), playerList);

        GameResponse gameResponse = new GameResponse(deck.getIdDeck());
        return gameResponse;
    }

    private Integer getNumberOfDecksNeeded(Integer numberCardsPerPlayer, Integer numberPlayers) {
        Integer defaultNumberDecks = 1;
        while((numberCardsPerPlayer * numberPlayers) > (defaultNumberDecks * NUMBER_CARDS_PER_DECK)) {
            defaultNumberDecks++;
        }
        return defaultNumberDecks;
    }

    private List<CardModel> getCards(String idDeck, Integer numberCardsPerPlayer) {
        return deckApiService.drawnCards(idDeck, numberCardsPerPlayer).getCards();
    }

    private GameEntity saveGame(GameEntity gameEntity) {
        return gameRepository.save(gameEntity);
    }

}
