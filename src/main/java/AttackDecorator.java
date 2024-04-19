import codemons.*;
import attacks.*;

public class AttackDecorator extends Codemon{
    protected Codemon codemon;
    protected Attack newAttack;

    public AttackDecorator(Codemon codemon, Attack newAttack) {
        super(codemon.getAttack(), codemon.getDefense(), codemon.getHealth(), codemon.getExpCap());
        this.codemon = codemon;
        this.newAttack = newAttack;
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
    public void levelUp(){ 
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
    public int getHp() {
        return codemon.getHp();
    }

    @Override
    public boolean isFainted() {
        return codemon.isFainted();
    }

    @Override
    public int getExp() {
        return codemon.getExp();
    }

    
}
