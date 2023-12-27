package stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTest {
    Stream<String> getStream() {
        return Stream.of("Budi", "Eko", "Dwi", "Joko");
    }

    @Test
    void testCollection() {
        Set<String> set = getStream().collect(Collectors.toSet());
        System.out.println(set);
        Set<String> unmodifiableSet = getStream().collect(Collectors.toUnmodifiableSet());
        System.out.println(unmodifiableSet);

        List<String> list = getStream().collect(Collectors.toList());
        System.out.println(list);
        List<String> unmodifiableList = getStream().collect(Collectors.toUnmodifiableList());
        System.out.println(unmodifiableList);
    }

    @Test
    void testMap() {
        Map<String, Integer> map = getStream().collect(Collectors.toMap(
                name -> name,
                String::length
        ));

        System.out.println(map);
    }
}
