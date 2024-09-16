package br.com.challenge.gameofcards.model;

import br.com.challenge.gameofcards.entity.Player;
import br.com.challenge.gameofcards.entity.PlayerCards;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PlayerDTO {

    private String name;

    private List<String> cards;

    public PlayerDTO(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getCards() {
        return cards;
    }

    public void addCards(List<CardModel> cards) {
        cards.forEach(x-> { this.cards.add(x.getCode());});
    }
}
