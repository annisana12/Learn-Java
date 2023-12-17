public class ForEach {
    public static void main(String[] args) {
        String[] catList = {
                "Meng Meng", "Meow Meow", "Pus Pus"
        };

        for (var cat : catList) {
            System.out.println(cat);
        }
    }
}
