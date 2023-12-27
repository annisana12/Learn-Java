package stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class TransformationOperationTest {

    @Test
    public void testMap() {
        List<String> fruits = List.of("Apple", "Orange", "Mango");

        fruits.stream()
                .map(String::toUpperCase)
                .map(String::length)
                .forEach(System.out::println);
    }

    @Test
    public void testFlatMap() {
        List.of("Apple", "Orange", "Mango").stream()
                .map(String::toUpperCase)
                .flatMap(upper -> Stream.of(upper, upper.length()))
                .flatMap(value -> Stream.of(value, value, value))
                .forEach(System.out::println);
    }
}
