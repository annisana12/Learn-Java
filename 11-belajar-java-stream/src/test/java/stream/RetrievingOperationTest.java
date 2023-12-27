package stream;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.Stream;

public class RetrievingOperationTest {

    @Test
    public void testLimit() {
        Stream.of("Eko", "Joko", "Supratman", "Soekarno", "Budi", "Dwi")
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void testSkip() {
        Stream.of("Eko", "Joko", "Supratman", "Soekarno", "Budi", "Dwi")
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void testTakeWhile() {
        Stream.of("Eko", "Joko", "Supratman", "Soekarno", "Budi", "Dwi")
                .takeWhile(name -> name.length() <= 4)
                .forEach(System.out::println);
    }

    @Test
    public void testDropWhile() {
        Stream.of("Eko", "Joko", "Supratman", "Soekarno", "Budi", "Dwi")
                .dropWhile(name -> name.length() <= 4)
                .forEach(System.out::println);
    }

    @Test
    public void testFindAny() {
        Optional<String> optional = Stream.of("Eko", "Joko", "Supratman", "Soekarno", "Budi", "Dwi")
                .findAny();

        optional.ifPresent(System.out::println);
    }

    @Test
    public void testFindFirst() {
        Optional<String> optional = Stream.of("Eko", "Joko", "Supratman", "Soekarno", "Budi", "Dwi")
                .findFirst();

        optional.ifPresent(System.out::println);
    }
}
