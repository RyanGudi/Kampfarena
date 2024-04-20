
public class Main {
    /**
     * Simulates a simple codemon game.
     * @param args arguement string
     */
    public static void main(String[] args) {       
        final EventSingleton eventSingleton = EventSingleton.getInstance();
        Trainer red = new Trainer("Red");
        red.addCodemon();
        red.printTeam();
        Trainer blue = new Trainer("Blue");
        blue.addCodemon();
        blue.printTeam();
        System.out.println();
        Game game = new Game(red, blue, eventSingleton);
        game.start(3); 
        red.printTeam();
        blue.printTeam();
    }
}