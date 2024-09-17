package br.com.challenge.gameofcards.models;

import br.com.challenge.gameofcards.entities.Player;
import br.com.challenge.gameofcards.entities.PlayerCards;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayerDTO {

    private Long id;

    private String name;

    private String cards;

    private Integer sumCards;

    public PlayerDTO() {

    }

    public PlayerDTO(Long id, String name, String cards, Integer sumCards) {
        this.id = id;
        this.name = name;
        this.cards = cards;
        this.sumCards = sumCards;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCards() {
        return cards;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCards(String cards) {
        this.cards = cards;
    }

    public void setSumCards(Integer sumCards) {
        this.sumCards = sumCards;
    }

    public static PlayerDTO convertToPlayerDTO(PlayerCards player) {
        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getIdPlayer());
        dto.setCards(player.getCards());
        dto.setSumCards(player.getTotalValue());
        return dto;
    }
}
