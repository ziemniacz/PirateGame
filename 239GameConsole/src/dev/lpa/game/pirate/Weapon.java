package dev.lpa.game.pirate;

public enum Weapon {
    SABER(50, 2), BLACK_POWDER_PISTOL(68, 5), CUDGEL(35, 0), KNIFE(30, 0), MUSKET(75, 7);

    private final int damage;
    private final int minLvl;

    Weapon(int damage, int minLvl) {
        this.damage = damage;
        this.minLvl = minLvl;
    }

    public static void displayWeapons(){
        System.out.println(CUDGEL + "\n" + SABER + "\n" + BLACK_POWDER_PISTOL);
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "damage=" + damage +
                ", minLvl=" + minLvl +
                "} " + super.toString();
    }

    public int getMinLvl() {
        return minLvl;
    }

    public int getDamage() {
        return damage;
    }
}
