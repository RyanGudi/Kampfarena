package codemons;

import java.util.List;
import attacks.Attack;

public class Grassmon extends Codemon{
    
    public Grassmon(int attack, int defense, int health, int expCap) {
        super(attack, defense, health, expCap);
        name = "Grassmon";
        type = "grass";
    }

    @Override
    public void levelUp() {
        attack += 3;
        defense += 5;
        health += 12;
        exp -= expCap;
        level++;
        if(level == 5) {
            evolve();
        }
    }

    public void evolve() {
        name = "Treemon";
        attack += 9;
        defense += 15;
        health += 36;
        hp = health;
    }
}
