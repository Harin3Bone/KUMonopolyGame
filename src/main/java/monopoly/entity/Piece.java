package monopoly.entity;

public class Piece {

    private Square location;

    public Piece(Square location) {
        // For initial start location
        this.location = location;
    }

    public Square getLocation() {
        // Get current piece location
        return location;
    }

    public void setLocation(Square location) {
        // For moving piece to new location
        this.location = location;
    }
}
