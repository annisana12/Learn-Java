package belajar_package.data;

public class Application {
    public static final int PROCESSORS;

    // Block static akan di run sebelum class nya di run
    static {
        System.out.println("Mengakses class Application");
        PROCESSORS = Runtime.getRuntime().availableProcessors();
    }
}
