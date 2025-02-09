package monopoly.entity;

import java.util.Random;

public class Die {

    private int faceValue;

    private static final Random random = new Random();

    public Die() {
        // faceValue must in range 1-6
        roll();
    }

    public void roll() {
        this.faceValue = random.nextInt(6) + 1;
    }

    public int getFaceValue() {
        return this.faceValue;
    }
}
