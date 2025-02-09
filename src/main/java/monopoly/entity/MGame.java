package monopoly.entity;

import java.util.ArrayList;
import java.util.List;

public class MGame {

    private int roundCnt;
    private int lastRound;
    private Board board;
    private List<Player> players;

    private static final List<Die> DICES = new ArrayList<>(List.of(new Die(), new Die()));
    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 8;

    private static final String INVALID_MIN_PLAYERS = "The number of players must be at least %s";
    private static final String INVALID_MAX_PLAYERS = "The number of players must be less than or equal to %s";

    public MGame() {
        // Set default round start at 1
        this.roundCnt = 1;

        // Set default final round at 20
        this.lastRound = 10;

        // Initial board setup
        this.board = new Board();
        this.board.init();
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player... players) {
        if ((this.players.size() + players.length) > MAX_PLAYERS) {
            throw new IllegalArgumentException(INVALID_MAX_PLAYERS.formatted(MAX_PLAYERS));
        }

        this.players.addAll(List.of(players));
    }

    public int getRoundCnt() {
        return roundCnt;
    }

    public void setRoundCnt(int roundCnt) {
        this.roundCnt = roundCnt;
    }

    public int getLastRound() {
        return lastRound;
    }

    public void setLastRound(int lastRound) {
        this.lastRound = lastRound;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void playGame() {
        validate();
        while (this.roundCnt <= this.lastRound) {
            System.out.println("Round %s".formatted(this.roundCnt));
            playRound();
            roundCnt++;
            System.out.println("********************************************************");
        }
    }

    private void validate() {
        if (this.players.size() < MIN_PLAYERS) throw new IllegalArgumentException(INVALID_MIN_PLAYERS.formatted(MIN_PLAYERS));
        if (this.players.size() > MAX_PLAYERS) throw new IllegalArgumentException(INVALID_MAX_PLAYERS.formatted(MAX_PLAYERS));
    }

    private void playRound() {
        for (var player : players) {
            var playerName = player.getName();

            System.out.println("Player %s turn".formatted(playerName));
            System.out.println("Player %s current location: %s".formatted(playerName, player.getPiece().getLocation().getName()));

            player.takeTurn(board, DICES);

            System.out.println("Player %s move to location: %s".formatted(playerName, player.getPiece().getLocation().getName()));
            System.out.println("--------------------------------------");
        }
    }

}
