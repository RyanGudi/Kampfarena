import java.util.concurrent.TimeUnit;

public class EventSingleton {
    private static EventSingleton instance;
    private boolean[] dayNightCycle;
    private String[] weatherCycle;
    private boolean isDay;
    private int timeIndex;
    private int weatherIndex;


    private EventSingleton() {
        dayNightCycle = new boolean[]{true, true, false};
        weatherCycle = new String[]{"clear", "rainy", "sunny"};
        timeIndex = 0;
        weatherIndex = 0;
    }

    /**
     * Gets the instance of the EventSingleton class.
     * @return
     */
    public static synchronized EventSingleton getInstance() {
        if (instance == null) {
            instance = new EventSingleton();
        }
        return instance;
    }

    public boolean isDay() {
        return dayNightCycle[timeIndex];
    }

    public String getWeatherCondition() {
        return weatherCycle[weatherIndex];
    }

    public void restartDayCycle() {
        timeIndex = 0;
    }

    /**
     * Cycles through the day and weather by 1.
     */
    public void advanceCycles() {
        timeIndex = (timeIndex + 1) % dayNightCycle.length;
        isDay = dayNightCycle[timeIndex];
        if (isDay) {
            weatherIndex = (weatherIndex + 1) % weatherCycle.length;
        }
    }

    /**
     * Cycles through day and weather by a num.
     * @param numTicks days cycled
     */
    public void simulateTicks(int numTicks) {
        for (int i = 0; i < numTicks; i++) {
            advanceCycles();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
