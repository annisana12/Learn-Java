package stream;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.stream.Stream;

public class OrderingOperationTest {

    @Test
    public void testSorted() {
        Stream.of("Eko", "Budi", "Joko", "Dwi")
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void testSortedWithComparator() {
        Comparator<String> comparator = Comparator.reverseOrder();

        Stream.of("Eko", "Budi", "Joko", "Dwi")
                .sorted(comparator)
                .forEach(System.out::println);
    }
}
