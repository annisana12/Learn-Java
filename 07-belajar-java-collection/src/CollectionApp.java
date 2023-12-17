import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionApp {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();

        collection.add("Mango");
        collection.add("Papaya");
        collection.addAll(List.of("Strawberry", "Cherry", "Apple", "Durian"));

        for (var fruit : collection) {
            System.out.println(fruit);
        }

        System.out.println("REMOVE");

        collection.remove("Papaya");
        collection.remove("Orange");
        collection.removeAll(List.of("Mango", "Durian"));

        for (var fruit : collection) {
            System.out.println(fruit);
        }

        System.out.println(collection.contains("Apple"));
        System.out.println(collection.containsAll(List.of("Strawberry", "Cherry")));
    }
}
