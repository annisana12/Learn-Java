public class Method {
    public static void main(String[] args) {
        sayHelloWorld();
        sayHello("Meow", "Meng");

        var a = 10;
        var b = 20;
        var result = sum(a, b);
        System.out.println(result);

        System.out.println(hitung(100, "+", 100));
        System.out.println(hitung(200, "-", 100));
        System.out.println(hitung(100, "salah", 100));
    }

    static void sayHelloWorld(){
        System.out.println("Hello World!");
    }

    static void sayHello(String firstName, String lastName) {
        System.out.println("Hello " + firstName + " " + lastName);
    }

    static int sum(int value1, int value2) {
        var total = value1 + value2;
        return total;
    }

    static int hitung(int value1, String operasi, int value2) {
        switch (operasi) {
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            default:
                return 0;
        }
    }
}
