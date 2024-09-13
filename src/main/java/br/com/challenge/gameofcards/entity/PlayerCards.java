package br.com.challenge.gameofcards.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_cards")
public class PlayerCards {
    @Id
    private Integer id;

    @Column(name = "id_player")
    private Integer idPlayer;

    @Column(name = "cards")
    private String cards;

    @Column(name = "total_value")
    private Integer total_value;

    public PlayerCards() {
    }

    public PlayerCards(Integer id, Integer idPlayer, String cards, Integer total_value) {
        this.id = id;
        this.idPlayer = idPlayer;
        this.cards = cards;
        this.total_value = total_value;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public String getCards() {
        return cards;
    }

    public Integer getTotal_value() {
        return total_value;
    }
}
