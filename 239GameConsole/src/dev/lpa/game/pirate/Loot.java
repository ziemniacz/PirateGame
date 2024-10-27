package dev.lpa.game.pirate;

public enum Loot {
    GOLD_COINS(1), PEARLS(2), GEMS(3), NECKLACE(4), RING_WITH_RUBIN(4);

    private final int scoreValue;

    Loot(int scoreValue) {
        this.scoreValue = scoreValue;
    }

    public int getScoreValue() {
        return scoreValue;
    }

}
