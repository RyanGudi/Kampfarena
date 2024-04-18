package codemons;

import java.util.List;
import java.util.ArrayList;
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
    protected int hp;
    protected boolean fainted;

    public Codemon(int attack, int defense, int health, int expCap) {
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.attacks =  new ArrayList<Attack>();
        this.expCap = expCap;
        hp = health;
        fainted = false;
    }

    public void displayStats() {
        System.out.println("Name: " + name +
                            "\nHP: " + hp +
                            "\nType: " + type +
                            "\nAttack: " + attack +
                            "\nDefense: " + defense +
                            "\nHealth: " + health +
                            "\nAttacks: " + attacks +
                            "\nExperience: " + exp +
                            "\nLevel: " + level +
                            "\nExperience Cap: " + expCap);
    }

    public void gainExp(int num) {
        exp += num;
        while(exp >= expCap) {
            levelUp();
        }
    }

    public void addAttack(Attack attack) {
        if(attacks.size() < 4) {
            attacks.add(attack);
        } else {
            System.out.println("Cant learn anymore moves");
        }
    }

    public abstract void levelUp();
    public abstract void evolve();

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getExpCap() {
        return expCap;
    }
}
