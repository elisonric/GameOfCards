package br.com.challenge.gameofcards;

import br.com.challenge.gameofcards.entities.Player;
import br.com.challenge.gameofcards.models.CardModel;
import br.com.challenge.gameofcards.models.DeckApiResponseModel;
import br.com.challenge.gameofcards.models.ImageModel;
import br.com.challenge.gameofcards.models.PlayerDTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class Mocks {

    public static DeckApiResponseModel deckApiResponseModel() {
        return new DeckApiResponseModel(true, "123", 52, true, cardModelList());
    }

    public static CardModel cardModel() {
        return new CardModel("2H", "img", imageModel(), "2", "SPADES");
    }

    public static ImageModel imageModel() {
        return new ImageModel("svg", "png");
    }

    public static PlayerDTO playerDTO() {return new PlayerDTO(1L,"Jogador1", "[2,3,4,5,KING]", 27);}

    public static Player player() {return new Player(1L,1L, "Jogador1", Timestamp.valueOf(LocalDateTime.now()));}

    public static List<PlayerDTO> playerDTOList() {
        return List.of(
                new PlayerDTO(1L, "Jogador1", "[2,3,4,5,KING]", 27),
                new PlayerDTO(2L, "Jogador2", "[2,5,7,9,ACE]", 24),
                new PlayerDTO(3L, "Jogador3", "[2,5,8,9,ACE]", 20),
                new PlayerDTO(4L, "Jogador4", "[2,5,4,9,ACE]", 15)
        );
    }

    public static List<Player> playerList() {
        return List.of(
                new Player(1L, 1L, "Jogador1", Timestamp.valueOf(LocalDateTime.now())),
                new Player(2L, 1L, "Jogador2", Timestamp.valueOf(LocalDateTime.now())),
                new Player(3L, 1L, "Jogador3", Timestamp.valueOf(LocalDateTime.now())),
                new Player(4L, 1L, "Jogador4", Timestamp.valueOf(LocalDateTime.now()))
        );
    }

    public static List<CardModel> cardModelList() {
        return List.of(
                new CardModel("2H", "img", imageModel(), "2", "SPADES"),
                new CardModel("3D", "img2", imageModel(), "3", "DIAMONDS"),
                new CardModel("4D", "img2", imageModel(), "4", "SPADES"),
                new CardModel("5D", "img2", imageModel(), "5", "SPADES"),
                new CardModel("6D", "img2", imageModel(), "6", "DIAMONDS"),
                new CardModel("7D", "img2", imageModel(), "7", "DIAMONDS"),
                new CardModel("8D", "img2", imageModel(), "8", "SPADES"),
                new CardModel("9D", "img2", imageModel(), "9", "DIAMONDS")
        );
    }
}
