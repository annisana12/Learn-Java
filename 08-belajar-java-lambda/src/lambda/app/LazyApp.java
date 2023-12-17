package lambda.app;

import java.util.function.Supplier;

public class LazyApp {
    public static void main(String[] args) {
        testScore(60, getName());

        System.out.println("Lazy Parameter");
        // testScoreLazyParam(60, () -> getName());
        testScoreLazyParam(60, LazyApp::getName);
    }

    public static void testScore(int score, String name) {
        if (score >= 80) {
            System.out.println("Selamat " + name + ", Anda lulus.");
        } else {
            System.out.println("Coba lagi tahun depan");
        }
    }

    public static void testScoreLazyParam(int score, Supplier<String> name) {
        if (score >= 80) {
            System.out.println("Selamat " + name.get() + ", Anda lulus.");
        } else {
            System.out.println("Coba lagi tahun depan");
        }
    }

    public static String getName() {
        System.out.println("getName di panggil");
        return "Budi";
    };
}
