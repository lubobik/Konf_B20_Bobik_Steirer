package at.fhj.iit.util;

public class DrinkUtils {
    public static double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    /**
     * Prints a dashed line out of 80 characters to the console.
     */
    public static void printSeparator() {
        System.out.println("-".repeat(110));
    }

    public static void printFormattedMetric(String message, double metric) {
        System.out.printf("%s: %.2f€\n", message, metric);
    }
}
