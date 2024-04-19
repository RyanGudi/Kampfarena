import codemons.*;
import attacks.Attack;

public class Main {



    
    public static void main(String[] args) {
        Codemon firemon = CodemonFactory.createCodemon("fire");
        Codemon watermon = CodemonFactory.createCodemon("water");
        Codemon grassmon = CodemonFactory.createCodemon("grass");
        


        System.out.println("Original");
        firemon.displayStats();

        for(int i = 0; i < 8; i++) {
            System.out.println("New Firemon");
            Codemon firemon2 = new AttackDecorator(firemon, new Attack(firemon.getType(), firemon.getLevel()));
            firemon2.gainExp(601);
            firemon2.displayStats();
        }
        
        System.out.println("Original");
        watermon.displayStats();

        for(int i = 0; i < 8; i++) {
            System.out.println("New Firemon");
            Codemon watermon2 = new AttackDecorator(watermon, new Attack(watermon.getType(), watermon.getLevel()));
            watermon2.gainExp(601);
            watermon2.displayStats();
        }

        System.out.println("Original");
        grassmon.displayStats();

        for(int i = 0; i < 8; i++) {
            System.out.println("New Firemon");
            Codemon grassmon2 = new AttackDecorator(grassmon, new Attack(grassmon.getType(), grassmon.getLevel()));
            grassmon2.gainExp(601);
            grassmon2.displayStats();
        }
        
    }
}