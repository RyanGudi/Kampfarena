package codemons;



public class Grassmon extends Codemon {
    
    /**
     * Grass based codemon.
     * @param attack attack
     * @param defense defense
     * @param health health
     * @param expCap exp limit
     */
    public Grassmon(int attack, int defense, int health, int expCap) {
        super(attack, defense, health, expCap);
        name = "Grassmon";
        type = "grass";
    }

    @Override
    public void levelUp() {
        if (level < levelCap) {
            attack += 3;
            defense += 5;
            health += 12;
            level++;
            if (level == 5) {
                evolve();
            }
        }
    }

    /**
     * Evolves grassmon to treemon.
     * and boosts stats
     */
    public void evolve() {
        name = "Treemon";
        attack += 9;
        defense += 15;
        health += 36;
        hp = health;
    }
}
