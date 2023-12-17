import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapApp {
    public static void main(String[] args) {
        NavigableMap<String, String> navigableMap = new TreeMap<>();

        navigableMap.put("Apple", "Apple");
        navigableMap.put("Orange", "Orange");
        navigableMap.put("Mango", "Mango");

        System.out.println(navigableMap);

        System.out.println(navigableMap.lowerKey("Mango"));
        System.out.println(navigableMap.higherKey("Mango"));

        NavigableMap<String, String> navigableMapDesc = navigableMap.descendingMap();
        System.out.println(navigableMapDesc);

        NavigableMap<String, String> empty = Collections.emptyNavigableMap();
        NavigableMap<String, String> immutable = Collections.unmodifiableNavigableMap(navigableMapDesc);
    }
}
