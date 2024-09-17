package br.com.challenge.gameofcards.models;

import jakarta.validation.constraints.Min;
import org.springframework.lang.NonNull;

public class GamePayload {

    @NonNull
    @Min(value = 2, message = "O numero de jogadores não pode ser menor do que 2")
    private Integer numberPlayers;

    @NonNull
    @Min(value = 1, message = "O numero de cartas não pode ser menor do que 1")
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
