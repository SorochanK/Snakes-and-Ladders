package com.snakes.game;

import com.snakes.game.unit.Dice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceTest {

    @Test
    public void rollDice() {
        for (int i = 0; i < 100; i++) {
            final int rolledDiceValue = new Dice().roll();
            assertTrue(rolledDiceValue >= 1 && rolledDiceValue <= 6);
        }
    }
}
