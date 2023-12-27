package stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class CheckOperationTest {

    @Test
    void testAnyMatch() {
        boolean result = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .anyMatch(number -> number > 5);

        System.out.println(result);
    }

    @Test
    void testAllMatch() {
        boolean result = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .allMatch(number -> number > 5);

        System.out.println(result);
    }

    @Test
    void testNoneMatch() {
        boolean result = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .noneMatch(number -> number > 5);

        System.out.println(result);
    }
}
