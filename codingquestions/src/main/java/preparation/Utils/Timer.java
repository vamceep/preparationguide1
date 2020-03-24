package preparation.Utils;

public class Timer {
    /**
     * Utility class to measure time.
     */
    private static long startTime = 0;
    public static void startTimer() {
        startTime = System.currentTimeMillis();
    }
    public static long getDuration() {
        return ((System.currentTimeMillis() - startTime) /1000);
    }
}
