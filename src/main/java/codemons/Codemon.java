package codemons;

import attacks.Attack;
import java.util.ArrayList;
import java.util.List;
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
    protected int levelCap;
    protected int hp;
    protected boolean fainted;

    /**
     * Initializes a new codemon with given stats.
     * @param attack attack
     * @param defense defense
     * @param health health
     * @param expCap exp limit
     */
    public Codemon(int attack, int defense, int health, int expCap) {
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.attacks =  new ArrayList<Attack>();
        this.expCap = expCap;
        hp = health;
        fainted = false;
        levelCap = 100;
    }

    /**
     * Displays the entire stats of a codemon.
     */
    public void displayStats() {
        System.out.println("Name: " + name + "\nHP: " + hp + "\nType: "
                         + type + "\nAttack: " + attack + "\nDefense: " 
                         + defense + "\nHealth: " + health + "\nAttacks: " 
                         + attacks + "\nExperience: " + exp + "\nLevel: " 
                         + level + "\nExperience Cap: " + expCap + "\n");
    }

    /**
     * Gives exp to a codemon and levels up if possible.
     * @param num number
     */
    public void gainExp(int num) {
        exp += num;
        while (exp >= expCap) {
            if (level < levelCap) {
                levelUp();
                exp -= expCap;
            } else {
                break;
            }
        }
    }

    /**
     * Adds an attack to the moveset.
     * @param attack attack
     */
    public void addAttack(Attack attack) {
        if (attacks.size() < 4 && !attacks.contains(attack)) {
            attacks.add(attack);
        } else {
            return;
        }
    }

    public abstract void levelUp();
    
    public abstract void evolve();

    /**
     * Returns random move from moveset.
     * @return
     */
    public Attack getRandomMove() {
        if (attacks.isEmpty()) {
            return null;
        } else {
            Random rand = new Random();
            int randomIndex = rand.nextInt(attacks.size());
            return attacks.get(randomIndex);
        }
    }

    /**
     * Codemon takes damage and faints if hp hits 0.
     * @param damage damage
     */
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp <= 0) {
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

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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
