import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListApp {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>(100);
        List<String> linkedList = new LinkedList<>();

        arrayList.add("Apple");
        arrayList.add("Orange");
        arrayList.add("Mango");

        arrayList.set(0, "Pear");
        arrayList.remove(1);
        System.out.println(arrayList.get(1));

        for (var value : arrayList) {
            System.out.println(value);
        }
    }
}
