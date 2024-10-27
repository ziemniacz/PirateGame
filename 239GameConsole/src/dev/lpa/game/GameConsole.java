package dev.lpa.game;

import java.util.Scanner;

public class GameConsole <T extends Game<? extends Player>>{

    private final T game;

    private static final Scanner scanner = new Scanner(System.in);

    public GameConsole(T game) {
        this.game = game;
    }

    public int addPlayer(){
        System.out.println("Enter your playing name: ");
        String name = scanner.nextLine();

        System.out.printf("Welcome to %s, %s!%n".formatted(game.getGameName(), name));
        return game.addPlayer(name);
    }

    public void playGame(int playerIndex){
        boolean done = false;
        while (!done){
            var gameActions = game.getGameAction(playerIndex);
            System.out.println("Select from one of the following actions: ");
            for (Character c : gameActions.keySet()){
                String prompt = gameActions.get(c).prompt();
                System.out.println("\t" + prompt + " (" + c + ")");
            }
            System.out.println("Enter Next Action: ");

            char nextMove = scanner.nextLine().toUpperCase().charAt(0);
            GameAction gameAction = gameActions.get(nextMove);

            if(gameAction != null){
                System.out.println();
                done = game.executeGameAction(playerIndex, gameAction);
                if(!done){
                    System.out.println();
                }
            }
        }
    }
}
