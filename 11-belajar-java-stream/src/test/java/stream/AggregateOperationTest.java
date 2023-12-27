package stream;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.stream.Stream;

public class AggregateOperationTest {

    @Test
    void testMax() {
        Stream.of("Eko", "Budi", "Joko", "Dwi")
                .max(Comparator.naturalOrder())
                .ifPresent(System.out::println);
    }

    @Test
    void testMin() {
        Stream.of("Eko", "Budi", "Joko", "Dwi")
                .min(Comparator.naturalOrder())
                .ifPresent(System.out::println);
    }

    @Test
    public void testCount() {
        long count = Stream.of("Eko", "Budi", "Joko", "Dwi").count();
        System.out.println(count);
    }

    @Test
    public void testSum() {
        var result = Stream.of(1,2,3,4,5)
                .reduce(0, (accumulator, item) -> accumulator + item);

        System.out.println(result);
    }

    @Test
    public void testFactorial() {
        var result = Stream.of(1,2,3,4,5)
                .reduce(1, (accumulator, item) -> accumulator * item);

        System.out.println(result);
    }
}
