package br.com.challenge.gameofcards.services;

import br.com.challenge.gameofcards.Mocks;
import br.com.challenge.gameofcards.clients.DeckApi;
import br.com.challenge.gameofcards.models.DeckApiResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class DeckApiServiceTest {

    @InjectMocks
    DeckApiService deckApiService;

    @Mock
    DeckApi deckApi;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createDeck() {
        DeckApiResponseModel mockResponse = Mocks.deckApiResponseModel();

        when(deckApi.createDeck(1)).thenReturn(mockResponse);

        DeckApiResponseModel response = deckApiService.createDeck(1);
        assertEquals(52, response.getRemaining());
    }

    @Test
    void drawnCards() {
        DeckApiResponseModel mockResponse = Mocks.deckApiResponseModel();
        when(deckApi.drawnCards("abc", 1)).thenReturn(mockResponse);
        DeckApiResponseModel respose = deckApiService.drawnCards("abc", 1);
        assertEquals(1, respose.getCards().size());
    }
}