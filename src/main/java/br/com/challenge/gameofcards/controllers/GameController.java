package br.com.challenge.gameofcards.controllers;

import br.com.challenge.gameofcards.models.GamePayload;
import br.com.challenge.gameofcards.models.GameResponse;
import br.com.challenge.gameofcards.services.GameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/start")
    public ResponseEntity<GameResponse> start(@Valid @RequestBody GamePayload gamePayload) {
        return ResponseEntity.ok(gameService.start(gamePayload));
    }

    @GetMapping("")
    public ResponseEntity<GameResponse> find(@RequestParam("idDeck") String idDeck) throws NoSuchElementException {
        return ResponseEntity.ok(gameService.findGame(idDeck));
    }
}
