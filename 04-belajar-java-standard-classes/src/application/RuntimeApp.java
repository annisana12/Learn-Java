package application;

public class RuntimeApp {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        System.out.println(runtime.availableProcessors()); // jumlah core CPU
        System.out.println(runtime.freeMemory()); // free memory JVM
        System.out.println(runtime.totalMemory());
        System.out.println(runtime.maxMemory());
    }
}
