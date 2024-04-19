import codemons.*;
import attacks.*;

public class Main {



    
    public static void main(String[] args) {       
        EventSingleton eventSingleton = EventSingleton.getInstance();
        Trainer red = new Trainer("Red");
        red.addCodemon();
        red.printTeam();
        Trainer blue = new Trainer("Blue");
        blue.addCodemon();
        blue.printTeam();
        System.out.println();
        Game game = new Game(red, blue, eventSingleton);
        game.start(100); 
        red.printTeam();
        blue.printTeam();
        
        // for(int i = 0; i < 100; i++) {
            
        // }
    }
}