import java.util.EnumMap;
import java.util.Map;

public class EnumMapApp {

    public enum Level {
        STANDARD, PREMIUM, VIP
    }

    public static void main(String[] args) {
        Map<Level, String> map = new EnumMap<>(Level.class);

        map.put(Level.STANDARD, "Standard subscription");
        map.put(Level.PREMIUM, "Premium subscription");

        for (var key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
