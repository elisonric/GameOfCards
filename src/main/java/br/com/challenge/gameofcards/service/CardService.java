package br.com.challenge.gameofcards.service;

import br.com.challenge.gameofcards.model.CardModel;
import br.com.challenge.gameofcards.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private DeckApiService deckApiService;

    public List<CardModel> getCards(String idDeck, Integer numberCardsPerPlayer, Integer numberPlayers) {
        return deckApiService.drawnCards(idDeck, numberCardsPerPlayer * numberPlayers).getCards();
    }
}
