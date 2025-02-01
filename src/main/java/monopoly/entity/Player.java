package main.java.monopoly.entity;

import java.util.List;

public class Player {

    private String name;
    private Piece piece;

    public Player(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void takeTurn(Board board, List<Die> dices) {
        var fvTot = 0;
        var index = 0;
        for (var dice : dices) {
            dice.roll();
            System.out.println("Dice " + (++index) + " face value: " + dice.getFaceValue());
            fvTot += dice.getFaceValue();
        }
        System.out.println("Total face value: " + fvTot);

        var oldLoc = piece.getLocation();
        var newLoc = board.getLocation(oldLoc, fvTot);
        this.piece.setLocation(newLoc);
    }

}
