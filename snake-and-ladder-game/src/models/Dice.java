package models;

import java.util.random.RandomGeneratorFactory;

public class Dice {
    private static Dice dice;
    private Dice() {};
    private byte seed;

    public static synchronized Dice getDice() {
        if(dice == null) {
            dice = new Dice();
        }
        return dice;
    }

    public int roll() {
        return RandomGeneratorFactory.getDefault().create(this.seed).nextInt(1, 7);
    }
}
