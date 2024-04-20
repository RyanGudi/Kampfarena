package codemons;



public class Watermon extends Codemon {
    
    /**
     * Water based codemon.
     * @param attack attack
     * @param defense defense
     * @param health health
     * @param expCap exp limit
     */
    public Watermon(int attack, int defense, int health, int expCap) {
        super(attack, defense, health, expCap);
        name = "Watermon";
        type = "water";
    }

    @Override
    public void levelUp() {
        if (level < levelCap) {
            attack += 3;
            defense += 3;
            health += 15;
            level++;
            if (level == 5) {
                evolve();
            }
        }
    }

    /**
     * Evolves watermon to icemon.
     * and boosts stats
     */
    public void evolve() {
        name = "Icemon";
        attack += 9;
        defense += 9;
        health += 45;
        hp = health;
    }
}
