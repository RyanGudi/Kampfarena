import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testMainPrintsHelloWorld() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.main(new String[]{});

        String expectedOutput = "Hello World";

        String actualOutput = outContent.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }
}