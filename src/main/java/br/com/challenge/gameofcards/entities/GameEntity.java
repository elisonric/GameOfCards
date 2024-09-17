package br.com.challenge.gameofcards.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "game")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
    @SequenceGenerator(name = "game_seq", sequenceName = "game_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "id_deck")
    private String idDeck;

    @Column(name = "players_number")
    private Integer playersNumber;

    @Column(name = "created_at")
    private Timestamp createdAt;

    public GameEntity(String idDeck, Integer playersNumber) {
        this.idDeck = idDeck;
        this.playersNumber = playersNumber;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public GameEntity(Long id, String idDeck, Integer playersNumber) {
        this.id = id;
        this.idDeck = idDeck;
        this.playersNumber = playersNumber;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public GameEntity() {
    }

    public GameEntity(Long id, String idDeck, Integer playersNumber, Timestamp createdAt) {
        this.id = id;
        this.idDeck = idDeck;
        this.playersNumber = playersNumber;
        this.createdAt = createdAt;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

}
