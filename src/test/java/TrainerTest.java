import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;

public class TrainerTest {
    private Trainer trainer;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    /**
     * Sets up a new trainer.
     */
    @Before
    public void setUp() {
        trainer = new Trainer("Red");
        assertEquals("Red", trainer.getName());
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAddCodemon() {
        assertEquals(1, trainer.team.size());
        trainer.addCodemon();
        assertEquals(2, trainer.team.size());
        trainer.addCodemon();
        trainer.addCodemon();
        trainer.addCodemon();
        trainer.addCodemon();
        trainer.addCodemon();
        assertEquals(6, trainer.team.size());
    }


    @Test
    public void testPrintTeam() {
        trainer.addCodemon();
        trainer.addCodemon();
        trainer.addCodemon();

        trainer.printTeam();
    }

    @Test
    public void testHasAliveCodemons() {
        assertTrue(trainer.hasAliveCodemons());
        trainer.addCodemon();
        assertTrue(trainer.hasAliveCodemons());
    }

    @Test
    public void testHealAllCodemons() {
        trainer.addCodemon();
        trainer.getCurrentCodemon().takeDamage(10);
        trainer.healAllCodemons();
        assertEquals(trainer.getCurrentCodemon().getHealth(), trainer.getCurrentCodemon().getHp());
    }

    @Test
    public void testGainExpForAllCodemons() {
        trainer.addCodemon();
        trainer.getCurrentCodemon().getExp();
        trainer.gainExpForAllCodemons(100);
        trainer.getCurrentCodemon().getExp();
        assertEquals(trainer.getTopCodemon().getLevel(), 1);
    }

    @Test
    public void testSetTeamLevel() {
        trainer.addCodemon();
        trainer.setTeamLevel(10);
        int levelAfter = trainer.getCurrentCodemon().getLevel();
        assertEquals(10, levelAfter);
    }

    
}