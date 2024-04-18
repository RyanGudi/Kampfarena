package codemons;

import java.util.List;
import attacks.Attack;

public class Firemon extends Codemon{
    
    public Firemon(int attack, int defense, int health, List<Attack> attacks, int expCap) {
        super(attack, defense, health, attacks, expCap);
        name = "Firemon";
        type = "fire";
    }

    @Override
    public void levelUp() {
        attack += 5;
        defense += 3;
        health += 10;
        while(exp >= expCap) {
            exp -= expCap;
            level++;
        }
        if(level >= 5 && !evolved) {
            evolve();
        }
    }

    public void evolve() {
        name = "Lavamon";
        attack += 15;
        defense += 9;
        health += 30;
        evolved = true;
    }
}
