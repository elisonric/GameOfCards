package br.com.challenge.gameofcards.controller;

import br.com.challenge.gameofcards.model.GamePayload;
import br.com.challenge.gameofcards.model.GameResponse;
import br.com.challenge.gameofcards.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/start")
    public ResponseEntity<GameResponse> start(@RequestBody GamePayload gamePayload) {

        return ResponseEntity.ok(gameService.start(gamePayload));
    }
}
