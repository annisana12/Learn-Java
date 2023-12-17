public class WhileLoop {
    public static void main(String[] args) {
        var counter = 1;

        // Kondisi di cek dulu baru melakukan perulangan
        while (counter <= 10) {
            System.out.println("Perulangan ke-" + counter);
            counter++;
        }
    }
}
