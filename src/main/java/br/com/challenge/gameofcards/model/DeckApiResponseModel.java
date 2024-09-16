package br.com.challenge.gameofcards.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DeckApiResponseModel {

    private boolean success;

    @JsonProperty("deck_id")
    private String idDeck;
    
    private Integer remaining;

    private boolean shuffled;

    private List<CardModel> cards;

    public DeckApiResponseModel() {
    }

    public DeckApiResponseModel(boolean success, String idDeck, Integer remaining, boolean shuffled) {
        this.success = success;
        this.idDeck = idDeck;
        this.remaining = remaining;
        this.shuffled = shuffled;
    }

    public DeckApiResponseModel(boolean success, String idDeck, Integer remaining, List<CardModel> cards) {
        this.success = success;
        this.idDeck = idDeck;
        this.remaining = remaining;
        this.cards = cards;
    }

    public DeckApiResponseModel(boolean success, String idDeck, Integer remaining, boolean shuffled, List<CardModel> cards) {
        this.success = success;
        this.idDeck = idDeck;
        this.remaining = remaining;
        this.shuffled = shuffled;
        this.cards = cards;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getIdDeck() {
        return idDeck;
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
