import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapApp {
    public static void main(String[] args) {
        Map<String, String> empty = Collections.emptyMap();
        Map<String, String> single = Collections.singletonMap("name", "Budi");

        Map<String, String> mutable = new HashMap<>();
        mutable.put("name", "Budi");
        Map<String, String> immutable = Collections.unmodifiableMap(mutable);

        Map<String, String> map = Map.of(
                "firstName", "John",
                "middleName", "F.",
                "lastName", "Khennedy"
        );

        // map.put("name", "John"); error
    }
}
