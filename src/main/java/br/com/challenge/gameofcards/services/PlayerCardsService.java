package br.com.challenge.gameofcards.services;

import br.com.challenge.gameofcards.entities.Player;
import br.com.challenge.gameofcards.entities.PlayerCards;
import br.com.challenge.gameofcards.models.CardModel;
import br.com.challenge.gameofcards.repositories.PlayerCardsRepository;
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
            String cardsPlayer = cardModels.stream().map(x -> x.getCode()).toList().toString();
            cardModels.clear();
            //TODO fazer enum para valores de cartas e somatoria do total
            PlayerCards playerCards = new PlayerCards(playerList.get(i).getId(), cardsPlayer, 1);
            playerCardsList.add(playerCards);
        }
        playerRepository.saveAll(playerCardsList);
    }
}
