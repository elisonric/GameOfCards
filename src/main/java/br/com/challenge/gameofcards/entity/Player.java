package br.com.challenge.gameofcards.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "id_game")
    private Long idGame;

    @Column(name = "name")
    private String name;

    @Transient
    @Column(name = "created_at")
    private Timestamp createdAt;

    public Player(Long idGame, String name) {
        this.idGame = idGame;
        this.name = name;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public Long getId() {
        return id;
    }

    public Long getIdGame() {
        return idGame;
    }

    public String getName() {
        return name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}
