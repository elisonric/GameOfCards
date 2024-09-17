package br.com.challenge.gameofcards.services;

import br.com.challenge.gameofcards.entities.GameWinner;
import br.com.challenge.gameofcards.entities.PlayerCards;
import br.com.challenge.gameofcards.repositories.GameRepository;
import br.com.challenge.gameofcards.entities.GameEntity;
import br.com.challenge.gameofcards.entities.Player;
import br.com.challenge.gameofcards.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GameService {

    private static final Logger log = LoggerFactory.getLogger(GameService.class);

    private static final Integer NUMBER_CARDS_PER_DECK = 52;

    @Autowired
    private DeckApiService deckApiService;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerCardsService playerCardsService;

    @Autowired
    private GameWinnerService gameWinnerService;

    public GameResponse start(GamePayload gamePayload) {
        log.info("Iniciando o Jogo");

        DeckApiResponseModel deck = deckApiService.createDeck(getNumberOfDecksNeeded(gamePayload.getNumberCardsPerPlayer(), gamePayload.getNumberPlayers()));
        log.info("Deck Criado id: {}", deck.getIdDeck());

        log.info("Salvando o game no banco");
        GameEntity gameEntity = saveGame(new GameEntity(deck.getIdDeck(), gamePayload.getNumberPlayers()));
        log.info("Game salvo");

        log.info("Iniciando criação de {} players", gamePayload.getNumberPlayers());
        List<Player> playerList = playerService.createPlayers(gameEntity.getId(), gamePayload.getNumberPlayers());
        playerService.saveAll(playerList);

        log.info("Iniciando a distribuição de {} por player", gamePayload.getNumberCardsPerPlayer());
        List<PlayerCards> playerCards = playerCardsService.distributeCards(gameEntity.getIdDeck(), gamePayload.getNumberCardsPerPlayer(), playerList);
        playerCardsService.savePlayerCards(playerCards);

        log.info("Iniciando calculo de vencedor(es)");
        List<PlayerDTO> winners = gameWinnerService.calculateWinners(playerCards);
        gameWinnerService.saveWinners(winners, gameEntity);
        playerService.mergeNamePlayers(winners, playerList);

        return new GameResponse(deck.getIdDeck(), winners);
    }

    private Integer getNumberOfDecksNeeded(Integer numberCardsPerPlayer, Integer numberPlayers) {
        Integer defaultNumberDecks = 1;
        while((numberCardsPerPlayer * numberPlayers) > (defaultNumberDecks * NUMBER_CARDS_PER_DECK)) {
            defaultNumberDecks++;
        }
        return defaultNumberDecks;
    }

    private GameEntity saveGame(GameEntity gameEntity) {
        return gameRepository.save(gameEntity);
    }

    public GameResponse findGame(String idDeck) throws NoSuchElementException {
        Optional<GameEntity> gameEntity = gameRepository.findByIdDeck(idDeck);
        if (gameEntity.isEmpty()) {
            throw new NoSuchElementException("Jogo não encontrado para o idDeck: "+idDeck);
        }
        List<GameWinner> playersWinnersOfGame = gameWinnerService.findIdPlayersWinnersOfGame(gameEntity.get().getId());
        List<PlayerDTO> playerDTOS = new ArrayList<>();
        playersWinnersOfGame.forEach(gameWinner -> {
            Optional<Player> player = playerService.findById(gameWinner.getIdPlayer());
            PlayerCards cardsByIdPlayer = playerCardsService.findByIdPlayer(gameWinner.getIdPlayer());
            if (player.isPresent()) {
                PlayerDTO playerDTO = PlayerDTO.convertToPlayerDTO(cardsByIdPlayer);
                player.ifPresent(value -> playerDTO.setName(value.getName()));
                playerDTOS.add(playerDTO);
            }
        });
        return new GameResponse(gameEntity.get().getIdDeck(), playerDTOS);
    }

}
