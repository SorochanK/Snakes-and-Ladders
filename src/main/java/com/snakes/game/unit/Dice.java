package com.snakes.game.unit;

import org.springframework.stereotype.Component;

import static com.snakes.game.util.Randomizer.getRandomInt;

@Component
public class Dice {

    private static final int MIN_DICE_VALUE = 1;
    private static final int MAX_DICE_VALUE = 6;

    public int roll() {
        return getRandomInt(MIN_DICE_VALUE, MAX_DICE_VALUE);
    }
}
