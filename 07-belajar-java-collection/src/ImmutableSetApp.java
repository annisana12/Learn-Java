import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ImmutableSetApp {
    public static void main(String[] args) {
        Set<String> empty = Collections.emptySet();
        Set<String> one = Collections.singleton("Apple");

        Set<String> mutable = new HashSet<>();
        mutable.add("Apple");
        mutable.add("Orange");
        Set<String> immutable = Collections.unmodifiableSet(mutable);

        // immutable.add("Grape"); error
        // immutable.remove("Apple"); error

        Set<String> set = Set.of("Apple", "Orange", "Grape");
        System.out.println(set);
    }
}
