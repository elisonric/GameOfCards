package br.com.challenge.gameofcards.entities;

import com.google.common.annotations.VisibleForTesting;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
    @SequenceGenerator(name = "player_seq", sequenceName = "player_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "id_game")
    private Long idGame;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at")
    private Timestamp createdAt;

    public Player(Long idGame, String name) {
        this.idGame = idGame;
        this.name = name;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public Player(Long id, Long idGame, String name, Timestamp createdAt) {
        this.id = id;
        this.idGame = idGame;
        this.name = name;
        this.createdAt = createdAt;
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
}
