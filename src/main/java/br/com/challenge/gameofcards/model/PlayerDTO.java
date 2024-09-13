package br.com.challenge.gameofcards.model;

import br.com.challenge.gameofcards.entity.Player;
import br.com.challenge.gameofcards.entity.PlayerCards;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.sql.Timestamp;
import java.util.List;

public class PlayerDTO {

    private Integer id;

    private String name;

    private List<String> cards;
}
