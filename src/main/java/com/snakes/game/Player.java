package com.snakes.game;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.snakes.game.Game.START_POSITION;
import static com.snakes.game.Randomizer.getRandomInt;

@Data
@Component
@RequiredArgsConstructor
public class Player {
    private int id = getRandomInt(1, 10);
    private final Token token;
    private final Dice dice;

    public void initToken() {
        token.setPosition(START_POSITION);
    }

    public int rollDice() {
        return dice.roll();
    }
}
