import java.util.Properties;
import java.util.function.BiConsumer;

public class SystemProperties {
    public static void main(String[] args) {
        Properties properties = System.getProperties();

        properties.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
