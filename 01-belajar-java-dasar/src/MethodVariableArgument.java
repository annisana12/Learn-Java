public class MethodVariableArgument {
    public static void main(String[] args) {
        int[] nilai = {70, 60, 80, 60};

        sayCongrats("Budi", nilai);
        sayCongrats("Budi", 90, 80, 80, 80);
    }

    static void sayCongrats(String name, int... values) {
        var total = 0;

        for (var value : values) {
            total += value;
        }

        var nilaiAkhir = total / values.length;

        if (nilaiAkhir >= 75) {
            System.out.println("Selamat " + name + ", Anda lulus");
        } else {
            System.out.println("Maaf " + name + ", Anda belum lulus");
        }
    }
}
