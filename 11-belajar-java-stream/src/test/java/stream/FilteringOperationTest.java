package stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class FilteringOperationTest {

    @Test
    public void testFilter() {
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
    }

    @Test
    public void testDistinct() {
        Stream.of("Apple", "Orange", "Apple", "Mango", "Grape", "Orange")
                .distinct()
                .forEach(System.out::println);
    }
}
