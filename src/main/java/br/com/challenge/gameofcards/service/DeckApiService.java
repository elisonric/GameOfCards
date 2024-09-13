package br.com.challenge.gameofcards.service;

import br.com.challenge.gameofcards.client.DeckApi;
import br.com.challenge.gameofcards.model.DeckApiResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeckApiService {

    @Autowired
    private DeckApi deckApi;

    public DeckApiResponseModel createDeck(int numberDecks) {
        return deckApi.createDeck(numberDecks);
    }

    public DeckApiResponseModel drawnCards(String idDeck, int numberCards) {
        return deckApi.drawnCards(idDeck, numberCards);
    }
}
