package br.com.challenge.gameofcards.entities;

import br.com.challenge.gameofcards.entities.ids.GameWinnerId;
import jakarta.persistence.*;

@Entity
@Table(name = "game_winner")
@IdClass(GameWinnerId.class)
public class GameWinner {

    @Id
    @Column(name = "id_game")
    private Long idGame;

    @Id
    @Column(name = "id_player")
    private Long idPlayer;

    public GameWinner(Long idGame, Long idPlayer) {
        this.idGame = idGame;
        this.idPlayer = idPlayer;
    }

    public GameWinner() {
    }

    public Long getIdGame() {
        return idGame;
    }

    public void setIdGame(Long idGame) {
        this.idGame = idGame;
    }

    public Long getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Long idPlayer) {
        this.idPlayer = idPlayer;
    }
}
