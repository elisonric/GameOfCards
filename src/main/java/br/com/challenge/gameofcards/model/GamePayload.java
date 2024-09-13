package br.com.challenge.gameofcards.model;

public class GamePayload {

    private Integer numberPlayers;

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
