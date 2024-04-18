package codemons;

import java.util.List;
import attacks.Attack;

public class Watermon extends Codemon{
    
    public Watermon(int attack, int defense, int health, List<Attack> attacks, int expCap) {
        super(attack, defense, health, attacks, expCap);
        name = "Watermon";
        type = "water";
    }

}
