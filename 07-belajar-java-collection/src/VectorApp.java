import java.util.List;
import java.util.Vector;

public class VectorApp {
    public static void main(String[] args) {
        List<String> list = new Vector<>();

        list.add("Apple");
        list.add("Mango");

        for (var el : list) {
            System.out.println(el);
        }
    }
}
