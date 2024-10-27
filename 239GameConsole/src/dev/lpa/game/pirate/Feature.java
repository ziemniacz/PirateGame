package dev.lpa.game.pirate;

public enum Feature {
    STRING_TRAP(-30), HOUND(-25), ALLIGATOR(-55), BEAR_TRAP(-40),
    HEALING_FOG(25), HEALTH_POTION(40), BANDAGES(15), MEAL_AT_TAVERN(10);

    private final int healthPoints;

    Feature(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

}
