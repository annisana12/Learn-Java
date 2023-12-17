public class SwitchStatement {
    public static void main(String[] args) {
        var nilai = "A";

        switch (nilai) {
            case "A":
                System.out.println("Wow, Anda lulus dengan baik");
                break;
            case "B":
            case "C":
                System.out.println("Nilai Anda cukup baik");
                break;
            case "D":
                System.out.println("Anda tidak lulus");
                break;
            default:
                System.out.println("Mungkin Anda salah jurusan");
        }

        // Switch Lambda --> Sejak Java 14
        switch (nilai) {
            case "A" -> {
                System.out.println("Selamat Anda Lulus");
                System.out.println("Nilai Anda sangat baik");
            }
            case "B", "C" -> System.out.println("Nilai Anda cukup baik");
            case "D" -> System.out.println("Anda tidak lulus");
            default -> System.out.println("Mungkin Anda salah jurusan");
        }

        // Yield --> Sejak Java 14
        var ucapan = switch (nilai) {
            case "A":
                yield "Wow, Anda lulus dengan baik";
            case "B", "C":
                yield "Nilai Anda cukup baik";
            case "D":
                yield  "Anda tidak lulus";
            default:
                yield "Mungkin Anda salah jurusan";
        };

        System.out.println(ucapan);
    }
}
