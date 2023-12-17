import java.util.Iterator;
import java.util.List;

public class IterableApp {
    public static void main(String[] args) {
        Iterable<String> cities = List.of("Bandung", "Jakarta", "Bogor");

        for (var city : cities) {
            System.out.println(city);
        }

        System.out.println("ITERATOR");

        Iterator<String> iterator = cities.iterator();

        while (iterator.hasNext()) {
            String city = iterator.next();
            System.out.println(city);
        }
    }
}
