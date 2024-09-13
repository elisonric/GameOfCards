package br.com.challenge.gameofcards;

import br.com.challenge.gameofcards.model.CardModel;
import br.com.challenge.gameofcards.model.DeckApiResponseModel;
import br.com.challenge.gameofcards.model.ImageModel;

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
