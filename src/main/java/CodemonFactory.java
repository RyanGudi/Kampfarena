import codemons.*;
import attacks.Attack;
import java.util.List;
import java.util.ArrayList;

public class CodemonFactory {
    public static Codemon createCodemon(String codemonType) {
        int attack;
        int defense;
        int health;
        List<Attack> attacks = new ArrayList<Attack>();
        int expCap = 100;

        switch(codemonType) {
            case "fire":
            attack = 10;
            defense = 5;
            health = 17;
            return new Firemon(attack, defense, health, attacks, expCap);
            case "water":
            attack = 7;
            defense = 7;
            health = 20;
            return new Watermon(attack, defense, health, attacks, expCap);
            case "grass":
            attack = 5;
            defense = 10;
            health = 25;
            return new Grassmon(attack, defense, health, attacks, expCap);
            default:
            throw new IllegalArgumentException("Invalid Codemon type" + codemonType);
        }

    }    
}
