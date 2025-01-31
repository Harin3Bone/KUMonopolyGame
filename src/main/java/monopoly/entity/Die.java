package main.java.monopoly.entity;

import java.util.Random;

public class Die {

    private int faceValue;

    private static final Random random = new Random();

    public Die() {
        // Set face value default to 1 because int default is 0 and dice face value must start from 1
        this.faceValue = 1;
    }

    public void roll() {
        this.faceValue = random.nextInt(6) + 1;
    }

    public int getFaceValue() {
        return this.faceValue;
    }
}
