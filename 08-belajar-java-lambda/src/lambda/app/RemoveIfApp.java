package lambda.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIfApp {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.addAll(List.of("Apple", "Orange", "Strawberry"));

        // For each (bukan solusi yang tepat, hasil tidak benar)
//        for (var value : fruits) {
//            if (value.length() > 5) {
//                fruits.remove(value);
//            }
//        }

        // anonymous class
//        fruits.removeIf(new Predicate<String>() {
//            @Override
//            public boolean test(String value) {
//                return value.length() > 5;
//            }
//        });

        // lambda
        fruits.removeIf(value -> value.length() > 5);

        System.out.println(fruits);
    }

}
