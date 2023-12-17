package lambda.app;

import java.util.function.Function;

public class FunctionApp {
    public static void main(String[] args) {
        Function<String, Integer> stringLength = value -> value.length();
        System.out.println(stringLength.apply("Apple"));
    }
}
