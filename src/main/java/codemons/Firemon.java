package codemons;

import java.util.List;
import attacks.Attack;

public class Firemon extends Codemon{
    
    public Firemon(int attack, int defense, int health, int expCap) {
        super(attack, defense, health, expCap);
        name = "Firemon";
        type = "fire";
    }

    @Override
    public void levelUp() {
        attack += 5;
        defense += 3;
        health += 10;
        exp -= expCap;
        level++;
        if(level == 5) {
            evolve();
        }
    }

    public void evolve() {
        name = "Lavamon";
        attack += 15;
        defense += 9;
        health += 30;
        hp = health;
    }
}
