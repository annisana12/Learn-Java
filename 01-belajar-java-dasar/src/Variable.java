public class Variable {
    public static void main(String[] args) {
        String name;
        name = "Meow meow";

        System.out.println(name);

        int age = 30;
        String address = "Indonesia";

        System.out.println(age);
        System.out.println(address);

        name = "Meng Meng";
        System.out.println(name);

        // Sejak Java 10 bisa pakai var
        var firstName = "Meng";
        var numberOfLegs = 4; // tipe data int

        final String applicationName = "Belajar JAVA";
        final var animalType = "Cat";
    }
}
