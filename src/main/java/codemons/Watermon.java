package codemons;

import java.util.List;
import attacks.Attack;

public class Watermon extends Codemon{
    
    public Watermon(int attack, int defense, int health, int expCap) {
        super(attack, defense, health, expCap);
        name = "Watermon";
        type = "water";
    }

    @Override
    public void levelUp() {
        attack += 3;
        defense += 3;
        health += 15;
        exp -= expCap;
        level++;
        if(level == 5) {
            evolve();
        }
    }

    public void evolve() {
        name = "Icemon";
        attack += 9;
        defense += 9;
        health += 45;
        hp = health;
    }
}
