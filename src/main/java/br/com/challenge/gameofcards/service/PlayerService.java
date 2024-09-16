package br.com.challenge.gameofcards.service;

import br.com.challenge.gameofcards.entity.Player;
import br.com.challenge.gameofcards.repository.PlayerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> createAndSavePlayers(Long idGame, Integer numberPlayers) {
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < numberPlayers; i++) {
            playerList.add(new Player(idGame, "Jogador" + (i+1)));
        }

        return Lists.newArrayList(playerRepository.saveAll(playerList));
    }
}
