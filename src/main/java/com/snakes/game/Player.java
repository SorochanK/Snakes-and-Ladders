package com.snakes.game;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import static com.snakes.game.Game.*;

@Getter
@Setter
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

    public void moveToken(int moves) {
        if (canMove(moves)) {
            token.setPosition(token.getPosition() + moves);
        }
    }

    public boolean canMove(int moves) {
        final int currentPosition = token.getPosition();
        return (currentPosition + moves) <= END_POSITION;
    }
}
