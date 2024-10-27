package dev.lpa;

import dev.lpa.game.GameConsole;
import dev.lpa.game.pirate.DaGame;

public class Main {
    public static void main(String[] args) {
        var console = new GameConsole<>(new DaGame("The Tale"));

        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);


    }
}
