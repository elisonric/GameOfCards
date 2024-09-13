package br.com.challenge.gameofcards.model;

import br.com.challenge.gameofcards.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GameResponse {

    private String idGame;

    private List<PlayerDTO> winner;

    public GameResponse(String idGame) {
        setIdGame(idGame);
        this.winner = new ArrayList<>();
    }

    public String getIdGame() {
        return idGame;
    }

    public void setIdGame(String idGame) {
        this.idGame = idGame;
    }

    public List<PlayerDTO> getWinner() {
        return winner;
    }

    public void setWinner(List<PlayerDTO> winner) {
        this.winner = winner;
    }
}
