import java.util.Hashtable;
import java.util.Map;

public class HashTableApp {
    public static void main(String[] args) {
        Map<String, String> map = new Hashtable<>();

        map.put("Apple", "Apple");
        map.put("Orange", "Orange");

        for (var key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
