package codemons;

import java.util.List;
import attacks.Attack;

public class Watermon extends Codemon{
    
    public Watermon(int attack, int defense, int health, List<Attack> attacks, int expCap) {
        super(attack, defense, health, attacks, expCap);
        name = "Watermon";
        type = "water";
    }

    @Override
    public void levelUp() {
        attack += 3;
        defense += 3;
        health += 15;
        while(exp >= expCap) {
            exp -= expCap;
            level++;
        }
        if(level >= 5 && !evolved) {
            evolve();
        }
    }

    public void evolve() {
        name = "Icemon";
        attack += 9;
        defense += 9;
        health += 45;
        evolved = true;
    }
}
