package br.com.challenge.gameofcards.client;

import br.com.challenge.gameofcards.model.DeckApiResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "DeckApi", url = "https://deckofcardsapi.com/api/deck")
public interface DeckApi {

    @PostMapping("/new/shuffle/")
    public DeckApiResponseModel createDeck(@RequestParam("deck_count") int idDeck);

    @GetMapping("{deck_id}/draw/")
    public DeckApiResponseModel drawnCards(@PathVariable("deck_id") String idDeck, @RequestParam("count") int numberCards);
}
