package com.snakes.game;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class Game {

    private final Player player;
    public static final int START_POSITION = 1;
    public static final int END_POSITION = 100;

    @SneakyThrows
    public void startGame() {
        player.initToken();

        final int rolledDiceValue = player.rollDice();
        if (isPlayerWinGame(player, rolledDiceValue)) {
            System.out.println("Player " + player + " won the game. Congrats!");
            return;
        }
        player.moveToken(rolledDiceValue);
    }

    public boolean isPlayerWinGame(Player player, int intendedMove) {
        return player.getToken().getPosition() + intendedMove == END_POSITION;
    }

    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.ints(min, max + 1)
                .findFirst()
                .getAsInt();
    }
}
