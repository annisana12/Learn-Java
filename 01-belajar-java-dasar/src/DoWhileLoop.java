public class DoWhileLoop {
    public static void main(String[] args) {
        var counter = 100;

        // Perulangan dijalankan dulu baru cek kondisi
        do {
            System.out.println("Perulangan ke-" + counter);
            counter++;
        } while (counter <= 10);
    }
}
