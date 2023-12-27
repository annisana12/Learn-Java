package stream;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreamTest {

    @Test
    public void testCreate() {
        IntStream intStream = IntStream.range(1, 11);
        intStream.forEach(System.out::println);

        LongStream longStream = LongStream.of(1L, 2L, 3L, 4L, 5L);
        longStream.forEach(System.out::println);

        DoubleStream doubleStream = DoubleStream.builder().add(0.1).add(0.2).build();
        doubleStream.forEach(System.out::println);
    }

    @Test
    public void testOperations() {
        IntStream intStream = IntStream.range(1, 100);

        OptionalDouble average = intStream.average();
        average.ifPresent(System.out::println);

        IntStream.range(0,100)
                .mapToObj(number -> "Number : " + number)
                .forEach(System.out::println);
    }
}
