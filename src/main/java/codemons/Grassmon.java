package codemons;

import java.util.List;
import attacks.Attack;

public class Grassmon extends Codemon{
    
    public Grassmon(int attack, int defense, int health, List<Attack> attacks, int expCap) {
        super(attack, defense, health, attacks, expCap);
        name = "Grassmon";
        type = "grass";
    }
}
