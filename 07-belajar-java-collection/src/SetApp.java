import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetApp {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();
        // Set<String> fruits = new LinkedHashSet<>();

        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Apple");

        for (var fruit: fruits) {
            System.out.println(fruit);
        }
    }
}
