package codemons;

import java.util.List;
import attacks.Attack;

public class Firemon extends Codemon{
    
    public Firemon(String name, String type, int attack, int defense, int health, List<Attack> attacks, int expCap) {
        super(name, type, attack, defense, health, attacks, expCap);
        name = "Firemon";

        type = "fire";
        attack = 10;
        defense = 5;
        health = 17;
    }

    public void displayStats() {
        System.out.println("Name: " + name);
    }
}
