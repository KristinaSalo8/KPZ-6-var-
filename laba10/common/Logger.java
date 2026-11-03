package common;

public class Logger {
    private static int tick = 0;
    public static void log(String source, String event) {
        tick += 5;
        System.out.printf("[%02d:%02d] [%s] %s%n", tick / 60, tick % 60, source, event);
    }
    public static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
