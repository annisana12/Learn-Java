import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntryApp {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("Budi", "Budi value");
        map.put("Eko", "Eko value");
        map.put("Joko", "Joko value");

        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (var entry : entries) {
            System.out.println(entry);
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
