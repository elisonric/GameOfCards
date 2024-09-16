package br.com.challenge.gameofcards.services;

import br.com.challenge.gameofcards.entities.Player;
import br.com.challenge.gameofcards.entities.PlayerCards;
import br.com.challenge.gameofcards.enums.CardEnum;
import br.com.challenge.gameofcards.models.CardModel;
import br.com.challenge.gameofcards.repositories.PlayerCardsRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PlayerCardsService {

    @Autowired
    private DeckApiService deckApiService;

    @Autowired
    private PlayerCardsRepository playerRepository;

    public List<PlayerCards> distributeCards(String idDeck, Integer numberCardsPerPlayer, List<Player> playerList) {
        List<CardModel> cards = getCards(idDeck, numberCardsPerPlayer, playerList.size());
        List<PlayerCards> playerCardsList =  new ArrayList<>();
        for (Player player : playerList) {
            List<CardModel> cardModels = cards.subList(0, numberCardsPerPlayer);
            String cardsPlayer = getCardsPlayerString(cardModels);
            Integer valueCards = calculateValueCards(cardModels);
            cardModels.clear();
            PlayerCards playerCards = new PlayerCards(player.getId(), cardsPlayer, valueCards);
            playerCardsList.add(playerCards);
        }
        return playerCardsList;
    }

    private Integer calculateValueCards(List<CardModel> cardModels) {
        return cardModels.stream().map(CardModel::getValue).map(CardEnum::fromCode).mapToInt(Integer::intValue).sum();
    }

    public List<CardModel> getCards(String idDeck, Integer numberCardsPerPlayer, Integer numberPlayers) {
        return deckApiService.drawnCards(idDeck, numberCardsPerPlayer * numberPlayers).getCards();
    }

    public String getCardsPlayerString(List<CardModel> cardModels) {
        return cardModels.stream().map(CardModel::getValue).toList().toString();
    }

    public void savePlayerCards(List<PlayerCards> playerCardsList) {
        playerRepository.saveAll(playerCardsList);
    }
}
