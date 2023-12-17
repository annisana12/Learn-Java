import java.util.HashMap;
import java.util.Map;

public class HashMapApp {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("first_name", "Budi");
        map.put("middle_name", "Setiawan");
        map.put("last_name", "Sentosa");

        System.out.println(map.get("first_name"));
        System.out.println(map.get("middle_name"));
        System.out.println(map.get("last_name"));
        System.out.println(map);
    }
}
