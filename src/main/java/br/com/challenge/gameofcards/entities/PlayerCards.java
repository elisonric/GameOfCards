package br.com.challenge.gameofcards.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "player_cards")
public class PlayerCards {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "id_player")
    private Long idPlayer;

    @Column(name = "cards")
    private String cards;

    @Column(name = "total_value")
    private Integer total_value;

    public PlayerCards() {
    }

    public PlayerCards(Long idPlayer, String cards, Integer total_value) {
        this.idPlayer = idPlayer;
        this.cards = cards;
        this.total_value = total_value;
    }

    public Integer getId() {
        return id;
    }

    public Long getIdPlayer() {
        return idPlayer;
    }

    public String getCards() {
        return cards;
    }

    public Integer getTotal_value() {
        return total_value;
    }
}
