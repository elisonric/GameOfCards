package br.com.challenge.gameofcards.service;

import br.com.challenge.gameofcards.client.DeckApi;
import br.com.challenge.gameofcards.model.DeckApiResponseModel;
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
