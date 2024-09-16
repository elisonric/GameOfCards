package br.com.challenge.gameofcards.models;

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
