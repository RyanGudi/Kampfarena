import org.junit.Before;
import org.junit.Test;

public class GameTest {
    private Game game;
    private Trainer red;
    private Trainer blue;
    EventSingleton eventSingleton;

    /**
     * Sets up a game and runs a simulation on it to check for exceptions.
     */
    @Before
    public void setUp() {
        eventSingleton = EventSingleton.getInstance();
        red = new Trainer("Red");
        red.addCodemon();
        blue = new Trainer("Blue");
        blue.addCodemon();
        game = new Game(red, blue, eventSingleton);
    }

    @Test
    public void testGameCompilation() {
        game.start(10);
    }
}
