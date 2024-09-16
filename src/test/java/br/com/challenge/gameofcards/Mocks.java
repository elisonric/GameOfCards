package br.com.challenge.gameofcards;

import br.com.challenge.gameofcards.models.CardModel;
import br.com.challenge.gameofcards.models.DeckApiResponseModel;
import br.com.challenge.gameofcards.models.ImageModel;

import java.util.List;

public class Mocks {

    public static DeckApiResponseModel deckApiResponseModel() {
        return new DeckApiResponseModel(true, "123", 52, true, List.of(cardModel()));
    }

    public static CardModel cardModel() {
        return new CardModel("2H", "img", imageModel(), "2", "SPADES");
    }

    public static ImageModel imageModel() {
        return new ImageModel("svg", "png");
    }
}
