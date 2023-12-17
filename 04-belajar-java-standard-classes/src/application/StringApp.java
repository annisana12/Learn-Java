package application;

public class StringApp {
    public static void main(String[] args) {
        String catName = "Meng Meow";
        String catNameLowerCase = catName.toLowerCase();
        String catNameUpperCase = catName.toUpperCase();

        System.out.println(catName);
        System.out.println(catNameLowerCase);
        System.out.println(catNameUpperCase);
        System.out.println(catName.length());
        System.out.println(catName.startsWith("M"));
        System.out.println(catName.endsWith("Meow"));

        String[] catNames = catName.split(" ");

        for (var name : catNames) {
            System.out.println(name);
        }

        System.out.println(" ".isBlank()); // true
        System.out.println(" ".isEmpty()); // false
        System.out.println("".isEmpty()); // true
        System.out.println(catName.charAt(0));

        char[] charList = catName.toCharArray();

        for (var value : charList) {
            System.out.println(value);
        }
    }
}
