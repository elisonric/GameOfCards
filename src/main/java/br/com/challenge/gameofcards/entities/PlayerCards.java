package br.com.challenge.gameofcards.entities;

import br.com.challenge.gameofcards.models.PlayerDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "player_cards")
public class PlayerCards {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_cards_seq")
    @SequenceGenerator(name = "player_cards_seq", sequenceName = "player_cards_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "id_player")
    private Long idPlayer;

    @Column(name = "cards")
    private String cards;

    @Column(name = "total_value")
    private Integer totalValue;

    public PlayerCards() {
    }

    public PlayerCards(Long idPlayer, String cards, Integer totalValue) {
        this.idPlayer = idPlayer;
        this.cards = cards;
        this.totalValue = totalValue;
    }

    public Long getId() {
        return id;
    }

    public Long getIdPlayer() {
        return idPlayer;
    }

    public String getCards() {
        return cards;
    }

    public Integer getTotalValue() {
        return totalValue;
    }

}
