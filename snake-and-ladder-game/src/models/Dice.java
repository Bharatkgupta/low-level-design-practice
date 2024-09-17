package models;

import java.util.random.RandomGeneratorFactory;

public class Dice {
    private static Dice dice;
    private Dice() {};

    public static synchronized Dice getDice() {
        if(dice == null) {
            dice = new Dice();
        }
        return dice;
    }

    public int roll() {
        return RandomGeneratorFactory.getDefault().create().nextInt(1, 7);
    }
}
