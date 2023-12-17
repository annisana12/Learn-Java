public class Array {
    public static void main(String[] args) {
        String[] catNamesList = new String[3];
        catNamesList[0] = "Meng Meng";
        catNamesList[1] = "Meow Meng";

        System.out.println(catNamesList[0]);
        System.out.println(catNamesList[1]);
        System.out.println(catNamesList[2]);

        catNamesList[2] = "Meow Meow";
        System.out.println(catNamesList[2]);

        String[] newCats = {
                "Cat", "Meng", "Meow"
        };

        int[] nilai = new int[]{
                90, 89, 80, 95
        };

        long[] price = {
                10000L, 100000L, 250000L
        };

        // Panjang Array
        System.out.println(price.length);

        // Penghapusan elemen array
        // Mengubah nilai elemen jadi 0 jika tipe data primitif
        // Mengubah nilai elemen jadi null jika tipe data bukan primitif
        nilai[0] = 0;
        newCats[0] = null;

        // Array dalam array
        String[][] fruits = {
                {"Apple", "Orange"},
                {"Strawberry", "Blueberry"},
                {"Cherry"}
        };

        System.out.println(fruits[0][1]); // Orange
        System.out.println(fruits[1][0]); // Strawberry
        System.out.println(fruits[0]); // {"Apple", "Orange"}
    }
}
