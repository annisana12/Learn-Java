package lambda.app;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class OptionalApp {
    public static void main(String[] args) {
        sayHello("Budi");

        String name = null;
        sayHello(name);
    }

    public static void sayHello(String name) {
//        Optional.ofNullable(name)
//                .map(String::toUpperCase)
//                .ifPresentOrElse(
//                        value -> System.out.println("HELLO " + value),
//                        () -> System.out.println("HELLO")
//                );

        String nameUpper = Optional.ofNullable(name)
                .map(String::toUpperCase)
                .orElse("TEMAN");

        System.out.println("HELLO " + nameUpper);

//        Optional<String> optionalName = Optional.ofNullable(name);
//
//        // Ubah ke upperCase pakai map
//        Optional<String> optionalNameUpper = optionalName.map(String::toUpperCase);
//
//        optionalNameUpper.ifPresent(value -> System.out.println("HELLO " + value));

        // check if null
//        if (name != null) {
//            System.out.println("HELLO " + name.toUpperCase());
//        }
    }
}
