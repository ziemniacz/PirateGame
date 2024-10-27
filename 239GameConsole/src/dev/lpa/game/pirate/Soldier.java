package dev.lpa.game.pirate;

import java.util.Random;

public final class Soldier extends Combatant {

    private static String[] names = new String[]{"Żelisław", "Bożydar", "Mieczysław", "Mieszko", "Aureliusz", "Boguchwał", "Cyprian"};

    public Soldier() {
        super(names[new Random().nextInt(names.length - 1)], Weapon.MUSKET, 100, 7);
    }

    @Override
    public int attack() {
        return new Random().nextInt((int) (Weapon.MUSKET.getDamage() * 0.25), Weapon.MUSKET.getDamage());
    }

    @Override
    public void changeHealth(int hp) {
        setHp(getHp() + hp);
        setHp(getHp() <= 0 ? 0 : getHp());

    }

    @Override
    public int dropXP(){
        return new Random().nextInt(1, 7);
    }

    @Override
    public String toString() {
        return "Soldier " + super.toString();
    }
}
