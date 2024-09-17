package br.com.challenge.gameofcards.services;

import br.com.challenge.gameofcards.Mocks;
import br.com.challenge.gameofcards.clients.DeckApi;
import br.com.challenge.gameofcards.entities.Player;
import br.com.challenge.gameofcards.entities.PlayerCards;
import br.com.challenge.gameofcards.models.CardModel;
import br.com.challenge.gameofcards.models.DeckApiResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class PlayerCardsServiceTest {

    @InjectMocks
    private PlayerCardsService playerCardsService;

    @Mock
    private DeckApiService deckApiService;

    @Mock
    private DeckApi deckApi;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void distributeCards() {
        List<CardModel> cards = new ArrayList<>(Mocks.deckApiResponseModel().getCards());
        List<Player> players = new ArrayList<>(Mocks.playerList());
        DeckApiResponseModel deckApiResponseModel = new DeckApiResponseModel(true, "idABC", 52,cards);

        when(deckApiService.drawnCards("idABC", 8)).thenReturn(deckApiResponseModel);
        when(deckApi.createDeck(Mockito.anyInt())).thenReturn(deckApiResponseModel);

        List<PlayerCards> playerCards = playerCardsService.distributeCards("idABC", 2, players);

        assertEquals(13, playerCards.get(2).getTotalValue());
        assertEquals("[6, 7]", playerCards.get(2).getCards());
    }

    @Test
    void getCardsPlayerString() {
        String cardsPlayerString = playerCardsService.getCardsPlayerString(Mocks.cardModelList());
        assertEquals("[2, 3, 4, 5, 6, 7, 8, ACE]", cardsPlayerString);
    }
}