package main.java.monopoly.entity;

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
            throw new IllegalArgumentException("The number of players must be less than or equal to %s".formatted(MAX_PLAYERS));
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
        while (this.roundCnt <= this.lastRound) {
            playRound();
            roundCnt++;
        }
    }

    private void playRound() {
        for (var player : players) {
            player.takeTurn(board, DICES);
        }
    }

}
