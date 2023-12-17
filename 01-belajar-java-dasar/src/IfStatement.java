public class IfStatement {
    public static void main(String[] args) {
        var absen = 70;
        var nilai = 90;

        if (absen >= 75 && nilai >= 75) {
            System.out.println("Selamat Anda Lulus");
        } else {
            System.out.println("Anda Tidak Lulus");
        }

        if (absen >= 80 && nilai >= 80) {
            System.out.println("Nilai Anda A");
        } else if (absen >= 70 && nilai >= 70) {
            System.out.println("Nilai Anda B");
        } else if (absen >= 60 && nilai >= 60) {
            System.out.println("Nilai Anda C");
        } else if (absen >= 50 && nilai >= 50) {
            System.out.println("Nilai Anda D");
        } else {
            System.out.println("Nilai Anda E");
        }
    }
}
