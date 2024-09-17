package br.com.challenge.gameofcards.services;

import br.com.challenge.gameofcards.Mocks;
import br.com.challenge.gameofcards.entities.GameEntity;
import br.com.challenge.gameofcards.entities.Player;
import br.com.challenge.gameofcards.models.CardModel;
import br.com.challenge.gameofcards.models.DeckApiResponseModel;
import br.com.challenge.gameofcards.models.GamePayload;
import br.com.challenge.gameofcards.models.GameResponse;
import br.com.challenge.gameofcards.repositories.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class GameServiceTest {

    @InjectMocks
    private GameService gameService;

    @Mock
    private DeckApiService deckApiService;

    @Mock
    private GameRepository gameRepository;

    @Mock
    private PlayerService playerService;

    @Mock
    private PlayerCardsService playerCardsService;

    @Mock
    private GameWinnerService gameWinnerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void start() {
        List<CardModel> cards = new ArrayList<>(Mocks.deckApiResponseModel().getCards());
        DeckApiResponseModel deckApiResponseModel = new DeckApiResponseModel(true, "123ABC", 52, cards);
        List<Player> players = new ArrayList<>(Mocks.playerList());
        Integer numberPlayers = 4;
        Integer numberCardsPerPlayer = 2;

        when(deckApiService.createDeck(1)).thenReturn(deckApiResponseModel);
        doReturn(Mocks.gameEntity()).when(gameRepository).save(any());
        when(playerService.createPlayers(Mocks.gameEntity().getId(), numberPlayers)).thenReturn(players);
        when(deckApiService.drawnCards(deckApiResponseModel.getIdDeck(), numberCardsPerPlayer)).thenReturn(deckApiResponseModel);
        when(playerCardsService.distributeCards(deckApiResponseModel.getIdDeck(), numberCardsPerPlayer, players)).thenReturn(Mocks.playerCardsList());
        when(gameWinnerService.calculateWinners(any())).thenReturn(List.of(Mocks.playerDTO()));

        GameResponse gameResponse = gameService.start(new GamePayload(numberPlayers, numberCardsPerPlayer));
        assertEquals(1L, gameResponse.getWinner().size());
        assertEquals(1L, gameResponse.getWinner().get(0).getId());
        assertEquals("Jogador1", gameResponse.getWinner().get(0).getName());
    }

    @Test
    void getNumberOfDecksNeeded() throws Exception {
        Method method = GameService.class.getDeclaredMethod("getNumberOfDecksNeeded", Integer.class, Integer.class);
        method.setAccessible(true);

        Integer result = (Integer) method.invoke(gameService, 5, 5);

        assertEquals(1, result);
    }

    @Test
    void getNumberOfDecksNeededMoreDecks() throws Exception {
        Method method = GameService.class.getDeclaredMethod("getNumberOfDecksNeeded", Integer.class, Integer.class);
        method.setAccessible(true);

        Integer result = (Integer) method.invoke(gameService, 10, 15);

        assertEquals(3, result);
    }
}