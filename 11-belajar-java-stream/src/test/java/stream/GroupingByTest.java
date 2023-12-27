package stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByTest {

    @Test
    void testGroupingBy() {
        Map<String, List<Integer>> group = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(Collectors.groupingBy(number -> number > 5 ? "Besar" : "Kecil"));

        System.out.println(group);
    }

    @Test
    void testGroupingBy2() {
        Map<String, List<String>> group = Stream.of("Apple", "Grape", "Orange", "Strawberry", "Pineapple", "Mango")
                .collect(Collectors.groupingBy(fruit -> fruit.length() > 5 ? "Besar" : "Kecil"));

        System.out.println(group);
    }

    @Test
    void testPartitioningBy() {
        Map<Boolean, List<Integer>> group = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(Collectors.partitioningBy(name -> name > 5));

        System.out.println(group);
    }
}
