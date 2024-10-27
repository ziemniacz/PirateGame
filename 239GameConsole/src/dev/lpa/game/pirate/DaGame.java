package dev.lpa.game.pirate;

import dev.lpa.game.Game;
import dev.lpa.game.GameAction;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class DaGame extends Game<Pirate> {
    Random random = new Random();
    public DaGame(String gameName) {
        super(gameName);
    }

    @Override
    public Pirate createNewPlayer(String name) {
        return new Pirate(name);
    }

    @Override
    public Map<Character, GameAction> getGameAction(int playerIndex) {
        var actions = new LinkedHashMap<>(Map.of(
                'L', new GameAction('L', "Level up", this :: lvlUp),
                'R', new GameAction('R', "Raid a town", this :: raidTown),
                'C', new GameAction('C', "Change your weapon", this :: changeWeapon)
        ));
        actions.putAll(getGameActions());
        return actions;
    }

    public boolean lvlUp(int playerIndex){
        return getPlayer(playerIndex).lvlUp();
    }

    public boolean raidTown(int playerIndex){
        return getPlayer(playerIndex).raidTown();
    }

    public boolean changeWeapon(int playerIndex){
        return getPlayer(playerIndex).changeWeapon();
    }
}
