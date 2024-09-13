package br.com.challenge.gameofcards.service;

import br.com.challenge.gameofcards.model.DeckApiResponseModel;
import br.com.challenge.gameofcards.model.GamePayload;
import br.com.challenge.gameofcards.model.GameResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private static final Logger log = LoggerFactory.getLogger(GameService.class);

    private static final Integer NUMBER_CARDS_PER_DECK = 52;

    @Autowired
    private DeckApiService deckApiService;

    public GameResponse start(GamePayload gamePayload) {
        log.info("Iniciando o Jogo");

        DeckApiResponseModel deck = deckApiService.createDeck(getNumberOfDecksNeeded(gamePayload));
        
        GameResponse gameResponse = new GameResponse();
        return gameResponse;
    }

    private Integer getNumberOfDecksNeeded(GamePayload gamePayload) {
        Integer defaultNumberDecks = 1;
        while((gamePayload.getNumberCardsPerPlayer() * gamePayload.getNumberPlayers()) > (defaultNumberDecks * NUMBER_CARDS_PER_DECK)) {
            defaultNumberDecks++;
        }
        return defaultNumberDecks;
    }
}
