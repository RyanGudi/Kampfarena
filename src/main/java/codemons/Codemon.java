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
    protected int level;
    protected boolean evolved;

    public Codemon(int attack, int defense, int health, List<Attack> attacks, int expCap) {
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.attacks = attacks;
        this.expCap = expCap;
        evolved = false;
    }

    public void displayStats() {
        System.out.println("Name: " + name +
                            "\nType: " + type +
                            "\nAttack: " + attack +
                            "\nDefense: " + defense +
                            "\nHealth: " + health +
                            "\nAttacks: " + attacks +
                            "\nExperience: " + exp +
                            "\nLevel: " + level +
                            "\nEvolved: " + evolved +
                            "\nExperience Cap: " + expCap);
    }

    public void gainExp(int num) {
        exp += num;
        if(exp >= expCap) {
            levelUp();
        }
    }

    public abstract void levelUp();
    public abstract void evolve();
}
