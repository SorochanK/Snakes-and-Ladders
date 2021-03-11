package com.snakes.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class GameTest {

    @Mock
    Player player;
    @Mock
    Token token;

    @InjectMocks
    Game game;

    @BeforeEach
    void init_mocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void isPlayerWinGame() {
        when(token.getPosition()).thenReturn(99);
        when(player.getToken()).thenReturn(token);
        final boolean playerWinGame = game.isPlayerWinGame(player, 1);
        assertTrue(playerWinGame);
    }

    @Test
    public void isPlayerDontWinGame() {
        when(token.getPosition()).thenReturn(98);
        when(player.getToken()).thenReturn(token);
        final boolean playerWinGame = game.isPlayerWinGame(player, 1);
        assertFalse(playerWinGame);
    }

    @Test
    public void testStartGame() {
        when(token.getPosition()).thenReturn(1);
        when(player.getToken()).thenReturn(token);
        int randomValue = new Random().nextInt(10);
        when(player.rollDice()).thenReturn(randomValue);
        game.startGame();
        verify(player, times(1)).initToken();
        verify(player, times(1)).moveToken(anyInt());
    }

    @Test
    public void testGameWhenPlayerWinsTheGame() {
        when(token.getPosition()).thenReturn(98);
        when(player.getToken()).thenReturn(token);
        when(player.rollDice()).thenReturn(2);
        game.startGame();
        verify(player, times(1)).initToken();
        verify(player, times(0)).moveToken(anyInt());
    }
}
