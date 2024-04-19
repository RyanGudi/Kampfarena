import codemons.*;
import attacks.*;

public class Main {



    
    public static void main(String[] args) {       
        Trainer red = new Trainer("Red");
        red.addCodemon();
        red.printTeam();
        Trainer blue = new Trainer("Blue");
        blue.addCodemon();
        blue.printTeam();

        //red.gainExpForAllCodemons(800);
        System.out.println();
        Game game = new Game(red, blue);
        game.start(); 
        red.printTeam();
        blue.printTeam();
        
        // for(int i = 0; i < 100; i++) {
            
        // }
    }
}