package br.com.challenge.gameofcards.entities.ids;


public class GameWinnerId {

    private Long idGame;

    private Long idPlayer;

    public GameWinnerId() {
    }

    public GameWinnerId(Long idGame, Long idPlayer) {
        this.idGame = idGame;
        this.idPlayer = idPlayer;
    }

    public Long getIdGame() {
        return idGame;
    }

    public void setIdGame(Long idGame) {
        this.idGame = idGame;
    }

    public Long getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Long idPlayer) {
        this.idPlayer = idPlayer;
    }
}
