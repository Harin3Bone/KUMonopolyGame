package monopoly;

import monopoly.entity.MGame;
import monopoly.entity.Piece;
import monopoly.entity.Player;

import java.util.List;

public class MonopolyApplication {

    public static void main(String[] args) {
        // Initialize the Monopoly game
        var mGame = new MGame();
        System.out.println("Monopoly game started");
        System.out.println("Total rounds: " + mGame.getLastRound());
        System.out.println("Total squares on board: " + mGame.getBoard().getSquares().size());

        // Add players to the game
        System.out.println("Adding players to the game");
        var playerNames = List.of("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Himmel");
        for (var playerName : playerNames) {
            var startLoc = mGame.getBoard().getStartLocation();
            var startPiece = new Piece(startLoc);
            mGame.addPlayer(new Player(playerName, startPiece));
        }

        // Start the game
        mGame.playGame();
    }
}