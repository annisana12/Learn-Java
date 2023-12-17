package application;

import java.util.StringJoiner;

public class StringJoinerApp {
    public static void main(String[] args) {
        String[] fruits = {
                "Apple", "Mango", "Cherry", "Strawberry"
        };

        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        for (var fruit : fruits) {
            joiner.add(fruit);
        }

        String fruitList = joiner.toString();
        System.out.println(fruitList);
    }
}
