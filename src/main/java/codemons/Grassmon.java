package codemons;

import java.util.List;
import attacks.Attack;

public class Grassmon extends Codemon{
    
    public Grassmon(String name, String type, int attack, int defense, int health, List<Attack> attacks, int expCap) {
        super(name, type, attack, defense, health, attacks, expCap);
        name = "Grassmon";

        type = "grass";
        attack = 5;
        defense = 10;
        health = 20;
    }

    public void displayStats() {
        System.out.println("Name: " + name);
    }
}
