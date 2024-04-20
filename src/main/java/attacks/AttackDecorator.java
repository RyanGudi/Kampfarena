package attacks;

import codemons.Codemon;

public class AttackDecorator extends Codemon {
    protected Codemon codemon;

    /**
     * Decorates a codemon and dynamically gives it a new move.
     * @param codemon codemon
     * @param newAttack new attack
     */
    public AttackDecorator(Codemon codemon, Attack newAttack) {
        super(codemon.getAttack(), codemon.getDefense(), codemon.getHealth(), codemon.getExpCap());
        setCodemon(codemon);
        addAttack(newAttack);
    }

    @Override
    public void addAttack(Attack attack) {
        codemon.addAttack(attack);
    }

    @Override
    public void displayStats() {
        codemon.displayStats();
        //System.out.println("Learned New Attack: " + newAttack.getName() + "\n");
    }

    @Override
    public Attack getRandomMove() {
        return codemon.getRandomMove();
    }

    @Override
    public void takeDamage(int damage) {
        codemon.takeDamage(damage);
    }

    @Override
    public void levelUp() { 
        codemon.levelUp();
    }

    @Override
    public void evolve() {
        codemon.evolve();
    }

    @Override
    public int getAttack() {
        return codemon.getAttack();
    }

    @Override
    public int getDefense() {
        return codemon.getDefense();
    }

    @Override
    public int getHealth() {
        return codemon.getHealth();
    }

    @Override
    public int getExpCap() {
        return codemon.getExpCap();
    }

    @Override
    public String getType() {
        return codemon.getType();
    }

    @Override
    public int getLevel() {
        return codemon.getLevel();
    }

    @Override
    public void setLevel(int level) {
        codemon.setLevel(level);
    }

    @Override
    public int getHp() {
        return codemon.getHp();
    }

    @Override
    public void setHp(int hp) {
        codemon.setHp(hp);
    }

    @Override
    public boolean isFainted() {
        return codemon.isFainted();
    }

    @Override
    public void setFainted(boolean fainted) {
        codemon.setFainted(fainted);
    }

    @Override
    public int getExp() {
        return codemon.getExp();
    }

    @Override
    public String getName() {
        return codemon.getName();
    }

    @Override
    public String toString() {
        String response = codemon.getName() + " (Level:  " + codemon.getLevel() + ") - ";
        if (codemon.isFainted()) {
            response += "Fainted";
        } else {
            response += "Healthy (" + codemon.getHp() + "/" + codemon.getHealth() + ")";
        }
        return response;
    }

    /**
     * Sets current codemon.
     * @param codemon codemon
     */
    private void setCodemon(Codemon codemon) {
        this.codemon = codemon;
    }
}
