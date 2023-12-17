package application;

public class NumberApp {
    public static void main(String[] args) {
        Integer intValue = 10;
        Double doubleValue = intValue.doubleValue();
        Long longValue = doubleValue.longValue();
        Short shortValue = longValue.shortValue();

        // Konversi String ke number
        String contoh = "10000";

        Integer number1 = Integer.valueOf(contoh);
        int number2 = Integer.parseInt(contoh);

        System.out.println(number1);
        System.out.println(number2);
    }
}
