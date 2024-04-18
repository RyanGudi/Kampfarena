import codemons.*;
import attacks.*;

public class AttackDecorator extends Codemon{
    protected Codemon codemon;
    protected Attack newAttack;

    public AttackDecorator(Codemon codemon, Attack newAttack) {
        super(codemon.getAttack(), codemon.getDefense(), codemon.getHealth(), codemon.getExpCap());
        this.codemon = codemon;
        this.newAttack = newAttack;
    }

    @Override
    public void addAttack(Attack attack) {
        codemon.addAttack(attack);
    }

    @Override
    public void displayStats() {
        codemon.displayStats();
        System.out.println("Learned New Attack: " + newAttack.getName());
    }

    @Override
    public void levelUp(){ 
    }

    @Override
    public void evolve() {
    }

    
}
