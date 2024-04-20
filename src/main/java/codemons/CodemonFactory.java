package codemons;

import attacks.Attack;
import attacks.AttackDecorator;

public class CodemonFactory {

    /**
     * Creates a new codemon from a given type.
     * @param codemonType codemon type
     * @return
     */
    public static Codemon createCodemon(String codemonType) {
        Codemon codemon;
        int attack;
        int defense;
        int health;
        int expCap = 100;

        switch (codemonType) {
            case "fire":
                attack = 10;
                defense = 5;
                health = 17;
                codemon = new Firemon(attack, defense, health, expCap);
                break;
            case "water":
                attack = 7;
                defense = 7;
                health = 20;
                codemon = new Watermon(attack, defense, health, expCap);
                break;
            case "grass":
                attack = 5;
                defense = 10;
                health = 25;
                codemon = new Grassmon(attack, defense, health, expCap);
                break;
            default:
                throw new IllegalArgumentException("Invalid Codemon type" + codemonType);
        }
        codemon = new AttackDecorator(codemon, new Attack(codemon.getType(), codemon.getLevel()));
        return codemon;
    }    
}
