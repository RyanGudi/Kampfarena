package codemons;

import java.util.List;
import java.util.ArrayList;
import attacks.*;
import java.util.Random;

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
                            "\nExperience Cap: " + expCap +
                            "\n");
    }

    public void gainExp(int num) {
        exp += num;
        while(exp >= expCap) {
            levelUp();
            exp -= expCap;
        }
    }

    public void addAttack(Attack attack) {
        if(attacks.size() < 4 && !attacks.contains(attack)) {
            attacks.add(attack);
        } else {
            return;
        }
    }

    public abstract void levelUp();
    public abstract void evolve();

    public Attack getRandomMove() {
        if (attacks.isEmpty()) {
            return null;
        } else {
            Random rand = new Random();
            int randomIndex = rand.nextInt(attacks.size());
            return attacks.get(randomIndex);
        }
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if(hp <= 0) {
            fainted = true;
            hp = 0;
        }
    }

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

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public boolean isFainted() {
        return fainted;
    }

    public void setFainted(boolean fainted) {
        this.fainted = fainted;
    }

    public int getExp() {
        return exp;
    }

    public String getName() {
        return name;
    }
}
