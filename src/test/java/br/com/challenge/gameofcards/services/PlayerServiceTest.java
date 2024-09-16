package br.com.challenge.gameofcards.services;

import br.com.challenge.gameofcards.Mocks;
import br.com.challenge.gameofcards.entities.Player;
import br.com.challenge.gameofcards.models.PlayerDTO;
import br.com.challenge.gameofcards.repositories.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class PlayerServiceTest {

    @InjectMocks
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPlayers() {
        List<Player> players = playerService.createPlayers(1L, 3);
        assertEquals(3, players.size());
        assertEquals("Jogador2", players.get(1).getName());
        assertEquals(1L, players.get(0).getIdGame());
    }

    @Test
    void mergeNamePlayers() {
        List<PlayerDTO> playerDTOS = Mocks.playerDTOList();
        playerDTOS.get(0).setName(null);
        playerService.mergeNamePlayers(playerDTOS, Mocks.playerList());

        assertEquals("Jogador4", playerDTOS.get(3).getName());
    }
}