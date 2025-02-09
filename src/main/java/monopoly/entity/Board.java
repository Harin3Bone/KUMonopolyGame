package monopoly.entity;

import java.util.ArrayList;
import java.util.List;

public class Board {

    // List of squares on the board limit at 40
    private List<Square> squares = new ArrayList<>();

    private static final int MAX_SQUARES = 40;
    private static final String INVALID_SQUARES = "Invalid number of squares";
    private static final String INVALID_LOCATION = "Invalid location";

    public Board() {}

    public Board(List<Square> squares) {
        if (squares.size() >= MAX_SQUARES) {
            throw new IllegalArgumentException(INVALID_SQUARES);
        }
        this.squares = squares;
    }

    public void init() {
        // Initialize the board with MAX_SQUARES
        for (var i = 0; i < MAX_SQUARES; i++) {
            var pos = i + 1;
            squares.add(new Square("square_" + pos, i));
        }
    }

    public List<Square> getSquares() {
        return this.squares;
    }

    public void setSquares(List<Square> squares) {
        if (this.squares.size() + squares.size() >= MAX_SQUARES) {
            throw new IllegalArgumentException(INVALID_SQUARES);
        }
        this.squares.addAll(squares);
    }

    public Square getStartLocation() {
        return squares.get(0);
    }

    public Square getLocation(Square oldLoc, int fvTot) {
        var newLoc = (oldLoc.getPosition() + fvTot - 1) % MAX_SQUARES + 1;
        if (newLoc >= 0 && newLoc < squares.size()) {
            return squares.get(newLoc);
        }
        throw new IllegalArgumentException(INVALID_LOCATION);
    }
}
