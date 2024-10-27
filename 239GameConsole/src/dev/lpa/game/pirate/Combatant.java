package dev.lpa.game.pirate;

public abstract sealed class Combatant permits Islander, Pirate, Soldier {

    private final String name;
    private Weapon weapon;
    private int hp;
    private int level;

    public Combatant(String name, Weapon weapon, int hp, int level) {
        this.name = name;
        this.weapon = weapon;
        this.hp = hp;
        this.level = level;
    }

    public Combatant(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public Combatant() {
        name = "";
    }

    public abstract int attack();
    public abstract void changeHealth(int hp);
    public abstract int dropXP();

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    protected void levelUp(){
        level++;
    }

    protected void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        return name;
    }
}
