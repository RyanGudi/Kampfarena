import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EventSingletonTest {

    @Test
    public void testGetInstance() {
        EventSingleton instance1 = EventSingleton.getInstance();
        EventSingleton instance2 = EventSingleton.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    public void testIsDay() {
        EventSingleton instance = EventSingleton.getInstance();

        assertTrue(instance.isDay());

        instance.advanceCycles();
        assertTrue(instance.isDay());

        instance.advanceCycles();
        assertFalse(instance.isDay());

        instance.restartDayCycle();
        assertTrue(instance.isDay());
    }

    @Test
    public void testGetWeatherCondition() {
        EventSingleton instance = EventSingleton.getInstance();

        instance.restartWeatherCycle();
        instance.restartDayCycle();
        assertEquals("clear", instance.getWeatherCondition());

        instance.advanceCycles();
        assertEquals("rainy", instance.getWeatherCondition());

        instance.restartDayCycle();
        instance.advanceCycles();
        assertEquals("sunny", instance.getWeatherCondition());
    }

    @Test
    public void testSimulateTicks() {
        EventSingleton instance = EventSingleton.getInstance();
        instance.restartDayCycle();
        instance.advanceCycles();
        instance.simulateTicks(2);

        assertTrue(instance.isDay());
        assertEquals("rainy", instance.getWeatherCondition());

    }
}