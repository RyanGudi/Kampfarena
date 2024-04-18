package codemons;

import java.util.List;
import attacks.Attack;

public class Grassmon extends Codemon{
    
    public Grassmon(int attack, int defense, int health, List<Attack> attacks, int expCap) {
        super(attack, defense, health, attacks, expCap);
        name = "Grassmon";
        type = "grass";
    }

    @Override
    public void levelUp() {
        attack += 3;
        defense += 5;
        health += 12;
        while(exp >= expCap) {
            exp -= expCap;
            level++;
        }
        if(level >= 5 && !evolved) {
            evolve();
        }
    }

    public void evolve() {
        name = "Treemon";
        attack += 9;
        defense += 15;
        health += 36;
        evolved = true;
    }
}
