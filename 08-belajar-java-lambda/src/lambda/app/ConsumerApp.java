package lambda.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerApp {
    public static void main(String[] args) {
        // Kalau perlu interface untuk nerima data pakai Consumer
        Consumer<String> consumer = data -> System.out.println(data);

        consumer.accept("Budi");
    }
}
