package dev.lpa.game.pirate;

import dev.lpa.game.Player;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public non-sealed class Pirate extends Combatant implements Player{

//    private final String name;
    private Town currentlyRaiding = new Town("", null, null, null);
    private Set<Town> townsVisited = new LinkedHashSet<>();
    private Weapon currentWeapon;
//    private int level;
//    private int hp;

    private int exp = 0;

    public Pirate(String name) {
        super(name, Weapon.CUDGEL, 100, 1);
//        level = 1;
//        hp = 100;
        currentWeapon = Weapon.CUDGEL;
        townsVisited.add(currentlyRaiding);
    }

    public boolean lvlUp(){
        if(exp == 10){
            levelUp();
            System.out.println("Level up! Your level is now " + getLevel());
            exp = 0;
        }
        else if(exp > 10){
            while (exp >= 10){
                levelUp();
                System.out.println("Level up! Your level is now " + getLevel());
                exp -= 10;
            }
        }
        else System.out.println("Pillage more towns in order to advance! You still need " + (10 - (exp % 10)) + " exp to advance!");
        return false;
    }

    public boolean raidTown(){
        int event = flipACoin();
        if(event % 2 == 0){
            if(! currentlyRaiding.featuresAreNull()) {
                Feature feature = currentlyRaiding.getRandomFeature();
                if ((getHp() + feature.getHealthPoints()) <= 0) {
                    System.out.println("You dead because of " + feature);
                    System.out.println("You bad lol");
                    return true;
                }
                setHp(getHp() + feature.getHealthPoints());
                System.out.println("You " + (feature.getHealthPoints() < 0 ? "lost " : "gained ") + feature.getHealthPoints() + " hp cuz of " + feature);
            }
        }

        else {
            if(! currentlyRaiding.opponentsAreNull()) {
                Combatant enemy = currentlyRaiding.getRandomOpponent();
                int healthRN = getHp();
                while (getHp() > 0 && enemy.getHp() > 0) {
                    enemy.changeHealth(-attack());
//                    System.out.println("E:" + enemy.getHp());
                    changeHealth(-enemy.attack());
//                    System.out.println("U:" + getHp());
                }
                if(getHp() <= 0){
                    System.out.println("You died cuz of " + enemy);
                    System.out.println("You bad lol");
                    return true;
                }
                else {
                    System.out.println("Killed " + enemy);
                    System.out.println("Obtained " + enemy.dropXP() + " xp cuz od it");
                    System.out.println("Lost " + (getHp() - healthRN));
                }
            }
        }

        Loot loot = currentlyRaiding.getLooted();
        if(loot == null) {
            System.out.println("The " + currentlyRaiding.getName() + " town has been completely dried out of goods!");
            currentlyRaiding = new Town("", null, null, null);
            townsVisited.add(currentlyRaiding);
            System.out.println("Your next objective will be " + currentlyRaiding.getName());
            return false;
        }
        exp += loot.getScoreValue();

        System.out.println(currentlyRaiding.getName() + " successfully raided!");
        System.out.println("You looted " + loot + " worth " + loot.getScoreValue());
        System.out.println("You're " + ((10 - (exp % 10)) == 10 ? "ready to advance!" : (10 - (exp % 10)) + " steps closer to next level!"));

        return false;
    }

    public boolean changeWeapon(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Here's a list of available weapons: ");
        Weapon.displayWeapons();
        Weapon weapon = Weapon.valueOf(scanner.nextLine().toUpperCase());
        if(weapon.getMinLvl() > getLevel()){
            System.out.println("You ain't cut for this weapon yet, pirate!");
        }
        else {
            System.out.println("Successfully changed");
            currentWeapon = weapon;
        }
        return false;
    }

    private int flipACoin(){
        return new Random().nextInt(0, 6);
    }

    @Override
    public int attack() {
        return new Random().nextInt( (int)(currentWeapon.getDamage() * 0.25), currentWeapon.getDamage() );
    }

    @Override
    public void changeHealth(int hp) {
        setHp(getHp() + hp);
        setHp(getHp() <= 0 ? 0 : getHp());
    }

    @Override
    public String name() {
        return getName();
    }

    @Override
    public String toString() {
        return "Pirate " + super.toString() +
                ", townsVisited=" + townsVisited +
                ", currentWeapon=" + currentWeapon +
                ", level=" + getLevel() +
                ", exp=" + exp +
                '}';
    }

    @Override
    public int dropXP() {
        return exp;
    }
}
