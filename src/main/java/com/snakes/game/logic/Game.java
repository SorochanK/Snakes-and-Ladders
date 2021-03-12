package com.snakes.game.logic;


import com.snakes.game.unit.Player;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

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
        if (isPlayerWin(player, rolledDiceValue)) {
            System.out.println("Player " + player + " won the game. Congrats!");
            return;
        }
        moveToken(player, rolledDiceValue);
    }

    public boolean isPlayerWin(Player player, int intendedMove) {
        return player.getToken().getPosition() + intendedMove == END_POSITION;
    }

    public void moveToken(Player player, int moves) {
        if (canMove(player, moves)) {
            player.getToken().setPosition(player.getToken().getPosition() + moves);
        }
    }

    public boolean canMove(Player player, int moves) {
        final int currentPosition = player.getToken().getPosition();
        return (currentPosition + moves) <= END_POSITION;
    }
}
