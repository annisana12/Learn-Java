import java.util.Collections;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class NavigableSetApp {
    public static void main(String[] args) {
        NavigableSet<String> cities = new TreeSet<>();
        cities.addAll(Set.of("Bandung", "Jakarta", "Surabaya", "Bali", "Solo"));
        System.out.println("Cities : " + cities);

        NavigableSet<String> citiesReversed = cities.descendingSet();
        System.out.println("Cities Reversed : " + citiesReversed);

        NavigableSet<String> headSet = cities.headSet("Bandung", true);
        System.out.println(headSet);

        NavigableSet<String> tailSet = cities.tailSet("Jakarta", true);
        System.out.println(tailSet);

        NavigableSet<String> immutable = Collections.unmodifiableNavigableSet(cities);
        // immutable.add("Yogyakarta"); error
    }
}
