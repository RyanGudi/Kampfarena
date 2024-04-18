package codemons;

import java.util.List;
import attacks.Attack;

public abstract class Codemon {
    protected String name;
    protected String type;
    protected int attack;
    protected int defense;
    protected int health;
    protected List<Attack> attacks;
    protected int exp;
    protected int expCap;

    public Codemon(String name, String type, int attack, int defense, int health, List<Attack> attacks, int expCap) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.attacks = attacks;
        this.expCap = expCap;
    }

    public abstract void displayStats();
}
