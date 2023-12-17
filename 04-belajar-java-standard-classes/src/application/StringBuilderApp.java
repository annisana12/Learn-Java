package application;

public class StringBuilderApp {
    public static void main(String[] args) {
        String name = "John";
        name += " " + "F.";
        name += " " + "Khennedy";

        /**
         * Di dalam memory akan disimpan di 3 lokasi
         * 1. John
         * 2. John F.
         * 3. John F. Khennedy
         */
        System.out.println(name);

        // StringBuilder hanya mengambil 1 lokasi di memori
        StringBuilder builder = new StringBuilder();
        builder.append("John");
        builder.append(" ");
        builder.append("F.");
        builder.append(" ");
        builder.append("Khennedy");

        String president = builder.toString();
        System.out.println(president);
    }
}
