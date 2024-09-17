package br.com.challenge.gameofcards.services;

import br.com.challenge.gameofcards.Mocks;
import br.com.challenge.gameofcards.entities.PlayerCards;
import br.com.challenge.gameofcards.models.PlayerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class GameWinnerServiceTest {

    @InjectMocks
    private GameWinnerService gameWinnerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void calculateWinnersOneWinner() {
        List<PlayerDTO> playerDTOS = gameWinnerService.calculateWinners(Mocks.playerCardsList());
        assertEquals(1, playerDTOS.size());
        assertEquals("[2, 5, 8, 9, ACE]", playerDTOS.get(0).getCards());
    }

    @Test
    void calculateWinnersWithAnyWinners() {
        List<PlayerCards> playerCards = new ArrayList<>(Mocks.playerCardsList());
        playerCards.add(new PlayerCards(5L, "[2, 3, 5, 9, ACE]", 25));
        List<PlayerDTO> playerDTOS = gameWinnerService.calculateWinners(playerCards);

        assertEquals(2,playerDTOS.size());
        assertEquals(1L, playerDTOS.get(0).getId());
        assertEquals(5L, playerDTOS.get(1).getId());
        assertEquals("[2, 5, 8, 9, ACE]", playerDTOS.get(0).getCards());
        assertEquals("[2, 3, 5, 9, ACE]", playerDTOS.get(1).getCards());
    }
}