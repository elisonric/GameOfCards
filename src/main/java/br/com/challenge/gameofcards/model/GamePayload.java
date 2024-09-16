package br.com.challenge.gameofcards.model;

import org.springframework.lang.NonNull;

public class GamePayload {

    @NonNull
    private Integer numberPlayers;

    @NonNull
    private Integer numberCardsPerPlayer;

    public GamePayload() {
    }

    public GamePayload(Integer numberPlayers, Integer numberCardsPerPlayer) {
        this.numberPlayers = numberPlayers;
        this.numberCardsPerPlayer = numberCardsPerPlayer;
    }

    public Integer getNumberPlayers() {
        return numberPlayers;
    }

    public Integer getNumberCardsPerPlayer() {
        return numberCardsPerPlayer;
    }
}
