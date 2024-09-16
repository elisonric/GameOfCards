package br.com.challenge.gameofcards.service;

import br.com.challenge.gameofcards.entity.Player;
import br.com.challenge.gameofcards.entity.PlayerCards;
import br.com.challenge.gameofcards.model.CardModel;
import br.com.challenge.gameofcards.repository.PlayerCardsRepository;
import br.com.challenge.gameofcards.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerCardsService {

    @Autowired
    private PlayerCardsRepository playerRepository;

    @Autowired
    private CardService cardService;

    public void distributeCards(String idDeck, Integer numberCardsPerPlayer, List<Player> playerList) {
        List<CardModel> cards = cardService.getCards(idDeck, numberCardsPerPlayer, playerList.size());
        List<PlayerCards> playerCardsList =  new ArrayList<>();
        for (int i = 0; i < playerList.size(); i++) {
            List<CardModel> cardModels = cards.subList(0, numberCardsPerPlayer);
            StringBuilder cardsString = new StringBuilder();
            cardModels.forEach(x -> {cardsString.append(x.getCode());});
            cardModels.clear();
            //TODO fazer enum para valores de cartas e somatoria do total
            PlayerCards playerCards = new PlayerCards(playerList.get(i).getId(), cardsString.toString(), 1);
            playerCardsList.add(playerCards);
        }
        playerRepository.saveAll(playerCardsList);
    }
}
