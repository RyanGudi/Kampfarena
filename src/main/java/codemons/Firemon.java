package codemons;



public class Firemon extends Codemon {
    
    /**
     * Fire based codemon.
     * @param attack attack
     * @param defense defense
     * @param health health
     * @param expCap exp limit
     */
    public Firemon(int attack, int defense, int health, int expCap) {
        super(attack, defense, health, expCap);
        name = "Firemon";
        type = "fire";
    }

    @Override
    public void levelUp() {
        if (level < levelCap) {
            attack += 5;
            defense += 3;
            health += 10;
            level++;
            if (level == 5) {
                evolve();
            }
        }
    }

    /**
     * Evolves firemon to lavamon.
     * and boosts stats
     */
    public void evolve() {
        name = "Lavamon";
        attack += 15;
        defense += 9;
        health += 30;
        hp = health;
    }
}
