import codemons.*;
import attacks.*;

public class Main {



    
    public static void main(String[] args) {
        // Codemon firemon = CodemonFactory.createCodemon("fire");
        // Codemon watermon = CodemonFactory.createCodemon("water");
        // Codemon grassmon = CodemonFactory.createCodemon("grass");
        
        
        Trainer red = new Trainer("Red");
        red.printTeam();
        Trainer blue = new Trainer("Blue");
        blue.printTeam();

        
        System.out.println();
        Game game = new Game(red, blue);
        game.start(); 
        red.printTeam();
        blue.printTeam();
        
        



        // System.out.println("Original");
        // firemon.displayStats();

        // for(int i = 0; i < 7; i++) {
        //     System.out.println("New Firemon");
        //     firemon.gainExp(100);
        //     firemon = new AttackDecorator(firemon, new Attack(firemon.getType(), firemon.getLevel()));
        //     firemon.displayStats();
        // }
        
        // System.out.println("Original");
        // watermon.displayStats();

        // for(int i = 0; i < 7; i++) {
        //     System.out.println("New Firemon");
        //     watermon.gainExp(100);
        //     watermon = new AttackDecorator(watermon, new Attack(watermon.getType(), watermon.getLevel()));
        //     watermon.displayStats();
        // }

        // System.out.println("Original");
        // grassmon.displayStats();

        // for(int i = 0; i < 7; i++) {
        //     System.out.println("New Firemon");
        //     grassmon.gainExp(100);
        //     grassmon = new AttackDecorator(grassmon, new Attack(grassmon.getType(), grassmon.getLevel()));
        //     grassmon.displayStats();
        // }
        
    }
}