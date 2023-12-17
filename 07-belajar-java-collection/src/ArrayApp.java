import java.util.Arrays;
import java.util.List;

public class ArrayApp {
    public static void main(String[] args) {
        List<String> list = List.of("Apple", "Mango", "Orange");

        Object[] objects = list.toArray();
        String[] strings = list.toArray(new String[]{});

        System.out.println(Arrays.toString(objects));
        System.out.println(Arrays.toString(strings));
    }
}
