package com.snakes.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenTest {

    @Test
    public void tokenTest() {
        final Token token = new Token();
        token.setPosition(1);
        assertEquals(1, token.getPosition());
    }
}
