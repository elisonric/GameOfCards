package br.com.challenge.gameofcards.clients;

import br.com.challenge.gameofcards.models.DeckApiResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "DeckApi", url = "https://deckofcardsapi.com/api/deck")
public interface DeckApi {

    @PostMapping("/new/shuffle")
    public DeckApiResponseModel createDeck(@RequestParam("deck_count") int deckCount);

    @GetMapping("{deck_id}/draw")
    public DeckApiResponseModel drawnCards(@PathVariable("deck_id") String idDeck, @RequestParam("count") int numberCards);
}
