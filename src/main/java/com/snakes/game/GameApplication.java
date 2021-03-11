package com.snakes.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameApplication implements CommandLineRunner {

    @Autowired
    private Game game;

    public static void main(String[] args) {
        SpringApplication.run(GameApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Welcome to the game!");
        game.startGame();
    }
}
