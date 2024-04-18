package codemons;

import java.util.List;
import attacks.Attack;

public class Firemon extends Codemon{
    
    public Firemon(int attack, int defense, int health, List<Attack> attacks, int expCap) {
        super(attack, defense, health, attacks, expCap);
        name = "Firemon";
        type = "fire";
    }
}
