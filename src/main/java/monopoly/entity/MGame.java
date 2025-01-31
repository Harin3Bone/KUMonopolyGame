package main.java.monopoly.entity;

import java.util.List;

public class MGame {

    private int roundCnt;
    private Board board;
    private Die dice;
    private List<Player> players;

    public MGame(int roundCnt) {
        this.roundCnt = roundCnt;
    }

    public void playGame() {}

    private void playRound() {}

}
