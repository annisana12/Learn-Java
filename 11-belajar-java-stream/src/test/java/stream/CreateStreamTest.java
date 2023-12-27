package stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class CreateStreamTest {

    @Test
    public void testCreateEmptyOrSingleStream() {
        Stream<String> emptyStream = Stream.empty();
        emptyStream.forEach(System.out::println);

        Stream<String> singleStream = Stream.of("Apple"); // data tidak boleh null
        singleStream.forEach(System.out::println);

        // Data bisa null atau tidak
        String data = null;
        Stream<String> emptyOrNotStream = Stream.ofNullable(data);
        emptyOrNotStream.forEach(System.out::println);
    }

    @Test
    public void testCreateStreamFromArray() {
        Stream<String> arrayStream = Stream.of("Apple", "Orange", "Mango");
        arrayStream.forEach(System.out::println);

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        integerStream.forEach(System.out::println);

        String[] array = new String[]{
                "Apple", "Orange", "Mango", "Grape"
        };
        Stream<String> streamFromArray = Arrays.stream(array);
        streamFromArray.forEach(System.out::println);
    }

    @Test
    public void testCreateStreamFromCollection() {
        Collection<String> collection = List.of("Apple", "Orange", "Mango");
        Stream<String> stringStream = collection.stream();
        stringStream.forEach(System.out::println);

        // stringStream.forEach(System.out::println); // error, hanya bisa mengalir 1x

        // Buat stream baru kalau mau buat aliran baru
        Stream<String> stringStream2 = collection.stream();
        stringStream2.forEach(System.out::println);
    }

    @Test
    public void testCreateInfiniteStream() {
        Stream<String> stream = Stream.generate(() -> "Apple");
        // stream.forEach(System.out::println);
        // result: Apple, Apple, Apple, Apple, Apple, ....

        Stream<Integer> iterate = Stream.iterate(1, value -> value + 1);
        // iterate.forEach(System.out::println);
        // result: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
    }
}
