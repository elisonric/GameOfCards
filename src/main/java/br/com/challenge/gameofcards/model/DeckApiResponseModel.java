package br.com.challenge.gameofcards.model;

import java.util.List;

public class DeckApiResponseModel {

    private boolean success;

    private String deck_id;
    
    private Integer remaining;

    private boolean shuffled;

    private List<CardModel> cards;

    public DeckApiResponseModel() {
    }

    public DeckApiResponseModel(boolean success, String deck_id, Integer remaining, boolean shuffled) {
        this.success = success;
        this.deck_id = deck_id;
        this.remaining = remaining;
        this.shuffled = shuffled;
    }

    public DeckApiResponseModel(boolean success, String deck_id, Integer remaining, List<CardModel> cards) {
        this.success = success;
        this.deck_id = deck_id;
        this.remaining = remaining;
        this.cards = cards;
    }

    public DeckApiResponseModel(boolean success, String deck_id, Integer remaining, boolean shuffled, List<CardModel> cards) {
        this.success = success;
        this.deck_id = deck_id;
        this.remaining = remaining;
        this.shuffled = shuffled;
        this.cards = cards;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public boolean isShuffled() {
        return shuffled;
    }

    public List<CardModel> getCards() {
        return cards;
    }
}
