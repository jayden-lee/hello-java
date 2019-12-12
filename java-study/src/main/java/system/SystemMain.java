package system;

public class SystemMain {

    public static void main(String[] args) {
        printCore();
        printMemory();
    }

    private static void printCore() {
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Processor: " + coreCount);
        System.out.println();
    }

    private static void printMemory() {
        long free  = Runtime.getRuntime().freeMemory();
        long total = Runtime.getRuntime().totalMemory();
        long max   = Runtime.getRuntime().maxMemory();

        System.out.format("Total Memory: %6.2f MB%n", (double) total / (1024 * 1024));
        System.out.format("Free  Memory: %6.2f MB%n", (double) free  / (1024 * 1024));
        System.out.format("Max   Memory: %6.2f MB%n", (double) max   / (1024 * 1024));
    }
}
