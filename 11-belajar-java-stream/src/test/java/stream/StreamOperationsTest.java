package stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class StreamOperationsTest {

    @Test
    public void testStreamOperation() {
        List<String> fruits = List.of("Apple", "Mango", "Orange");

        Stream<String> streamFruits = fruits.stream();
        Stream<String> streamFruitsUpper = streamFruits.map(String::toUpperCase);

        streamFruitsUpper.forEach(System.out::println);
        fruits.forEach(System.out::println);
    }
}
