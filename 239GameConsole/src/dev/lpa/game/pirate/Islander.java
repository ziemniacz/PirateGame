package dev.lpa.game.pirate;

import java.util.Random;

public final class Islander extends Combatant{

    private static String[] names = new String[]{"Jakub", "Jan", "Kamil", "Andrzej"};

    public Islander() {
        super(names[new Random().nextInt(names.length - 1)], Weapon.KNIFE, 100, 1);
    }

    @Override
    public int attack() {
        return new Random().nextInt((int) (Weapon.KNIFE.getDamage() * 0.25), Weapon.KNIFE.getDamage());
    }

    @Override
    public void changeHealth(int hp) {
        setHp(getHp() + hp);
        setHp(getHp() <= 0 ? 0 : getHp());

    }

    @Override
    public int dropXP(){
        return new Random().nextInt(0, 2);
    }

    @Override
    public String toString() {
        return "Islander " + super.toString();
    }
}
