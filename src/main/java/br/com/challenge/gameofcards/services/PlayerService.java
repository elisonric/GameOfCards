package br.com.challenge.gameofcards.services;

import br.com.challenge.gameofcards.entities.Player;
import br.com.challenge.gameofcards.models.PlayerDTO;
import br.com.challenge.gameofcards.repositories.PlayerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> createPlayers(Long idGame, Integer numberPlayers) {
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < numberPlayers; i++) {
            playerList.add(new Player(idGame, "Jogador" + (i+1)));
        }

        return playerList;
    }

    public void mergeNamePlayers(List<PlayerDTO> playerDtos,List<Player> players) {
        Map<Long, String> mapPlayerName = players.stream().collect(Collectors.toMap(Player::getId, Player::getName));
        for (PlayerDTO playerDto: playerDtos) {
            String playerName = mapPlayerName.get(playerDto.getId());
            if (playerName != null) {
                playerDto.setName(playerName);
            }
        }
    }

    public void saveAll(List<Player> players) {
        playerRepository.saveAll(players);
    }

    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }
}
