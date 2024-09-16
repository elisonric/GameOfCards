package br.com.challenge.gameofcards.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "game")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "id_deck")
    private String idDeck;

    @Column(name = "players_number")
    private Integer playersNumber;

    @Column(name = "id_winner")
    private Integer idWinner;

    @Column(name = "created_at")
    private Timestamp createdAt;

    public GameEntity(String idDeck, Integer playersNumber) {
        this.idDeck = idDeck;
        this.playersNumber = playersNumber;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public Long getId() {
        return id;
    }

    public String getIdDeck() {
        return idDeck;
    }

    public Integer getPlayersNumber() {
        return playersNumber;
    }

    public Integer getIdWinner() {
        return idWinner;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setIdWinner(Integer idWinner) {
        this.idWinner = idWinner;
    }
}
