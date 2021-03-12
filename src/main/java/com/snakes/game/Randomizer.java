package com.snakes.game;

import java.util.Random;

public class Randomizer {
    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.ints(min, max + 1)
                .findFirst()
                .getAsInt();
    }
}
