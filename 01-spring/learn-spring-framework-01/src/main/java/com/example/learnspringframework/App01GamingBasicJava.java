package com.example.learnspringframework;

import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.PacmanGame;

public class App01GamingBasicJava {

    public static void main(String[] args) {

//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var game = new PacmanGame(); // 1.Object creation
        var gameRunner = new GameRunner(game); // 2.Object creation + wiring of dependencies
        // Game is a Dependency of GameRunner
        gameRunner.run();
    }
}
