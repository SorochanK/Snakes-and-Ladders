package com.snakes.game.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class PlayerTest {

    @Mock
    Token token;
    @Mock
    Dice dice;

    @InjectMocks
    Player player;

    @BeforeEach
    void init_mocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void initToken() {
        player.initToken();
        verify(token, times(1)).setPosition(eq(1));
    }

    @Test
    public void rollDice() {
        int random = new Random().nextInt(10);
        when(dice.roll()).thenReturn(random);
        final int result = player.rollDice();
        assertEquals(random, result);
        verify(dice, times(1)).roll();
    }

}
