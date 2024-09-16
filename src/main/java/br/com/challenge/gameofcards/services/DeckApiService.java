package br.com.challenge.gameofcards.services;

import br.com.challenge.gameofcards.clients.DeckApi;
import br.com.challenge.gameofcards.models.DeckApiResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeckApiService {

    private static final Logger log = LoggerFactory.getLogger(GameService.class);

    @Autowired
    private DeckApi deckApi;

    public DeckApiResponseModel createDeck(Integer numberDecks) {
        log.info("Criação do deck");
        return deckApi.createDeck(numberDecks);
    }

    public DeckApiResponseModel drawnCards(String idDeck, Integer numberCards) {
        return deckApi.drawnCards(idDeck, numberCards);
    }
}
