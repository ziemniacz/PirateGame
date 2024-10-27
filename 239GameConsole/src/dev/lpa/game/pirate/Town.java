package dev.lpa.game.pirate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public record Town (String name, List<Loot> treasure, List<Combatant> opponents, List<Feature> features){

      private static List<String> s = new ArrayList<>(List.of("Ustrzyki Dolne", "Brzozów", "Dębica", "Jarosław", "Jasło", "Kolbuszowa", "Leżajsk", "Rzeszów", "Przemyśl", "Sanok", "Mielec", "Tarnobrzeg", "Stalowa Wola", "Lubaczów", "Strzyżów", "Łańcut", "Ropczyce", "Lesko", "Nisko", "Przeworsk"));

    private static final Loot[] loot = new Loot[]{Loot.GOLD_COINS, Loot.PEARLS, Loot.GEMS, Loot.NECKLACE, Loot.RING_WITH_RUBIN};

    private static final Feature[] featuresArray = new Feature[]{Feature.STRING_TRAP, Feature.HOUND, Feature.ALLIGATOR, Feature.BEAR_TRAP, Feature.HEALING_FOG, Feature.HEALTH_POTION, Feature.BANDAGES, Feature.MEAL_AT_TAVERN};


    public Town {
        Random random = new Random();

        name = s.get(new Random().nextInt(s.size() - 1));
        s.remove(name);

        treasure = new ArrayList<>();
        while (treasure.size() < 5){
            treasure.add(loot[random.nextInt(5)]);
        }

        opponents = new ArrayList<>();
        int which = random.nextInt(0, 2);
        while (opponents.size() < 6){
            opponents.add(which == 0 ? new Islander() : new Soldier());
        }

        features = new ArrayList<>();
        Feature randomFeature;
        while (features.size() < 5){
            randomFeature = featuresArray[random.nextInt(8)];
            features.add(randomFeature);
        }
    }


    public Loot getLooted(){
        if(treasure.isEmpty()){
            return null;
        }
        Loot finding = treasure.size() == 1 ? treasure.get(0) : treasure.get(new Random().nextInt(treasure.size() - 1));
        treasure.remove(finding);
        return finding;
    }

    public String getName() {
        return name;
    }

    public Feature getRandomFeature(){
        if(features.isEmpty()){
            return null;
        }
        Feature feature = features.size() == 1 ? features.get(0) : features.get(new Random().nextInt(features.size() - 1));
        features.remove(feature);
        return feature;
    }

    public Combatant getRandomOpponent(){
        if(opponents.isEmpty()){
            return null;
        }
        Combatant opponent = opponents.size() == 1 ? opponents.get(0) : opponents.get(new Random().nextInt(opponents.size() - 1));
        opponents.remove(opponent);
        return opponent;
    }


    public boolean opponentsAreNull() {
        return opponents.isEmpty();
    }

    public boolean featuresAreNull() {
        return features.isEmpty();
    }

    @Override
    public String toString() {
        return "Town " + name;
    }
}
