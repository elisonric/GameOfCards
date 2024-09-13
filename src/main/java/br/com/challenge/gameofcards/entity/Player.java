package br.com.challenge.gameofcards.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "player")
public class Player {

    @Id
    private Integer id;

    @Column(name = "id_game")
    private Integer idGame;

    @Column(name = "name")
    private String name;

    @Transient
    @Column(name = "created_at")
    private Timestamp createdAt;
}
