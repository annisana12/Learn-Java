package belajar_package.application;

public class EqualsApp {
    public static void main(String[] args) {
        String first = "Meow";
        first += " " + "Meng";

        String second = "Meow Meng";

        System.out.println("first: " + first);
        System.out.println("second: " + second);

        System.out.print("(first == second): ");
        System.out.println(first == second);
        System.out.print("(first.equals(second)): ");
        System.out.println(first.equals(second));

        String third = "Meow Meng";
        System.out.println("third: " + third);

        System.out.print("(second == third): ");
        System.out.println(second == third);
        System.out.print("(second.equals(third)): ");
        System.out.println(second.equals(third));
    }
}
