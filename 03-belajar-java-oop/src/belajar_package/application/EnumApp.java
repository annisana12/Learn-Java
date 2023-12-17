package belajar_package.application;

import belajar_package.data.Customer;
import belajar_package.data.Level;

public class EnumApp {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("Budi");
        customer.setLevel(Level.PREMIUM);

        System.out.println(customer.getName());
        System.out.println(customer.getLevel());
        System.out.println(customer.getLevel().getDescription());

        // Konversi enum ke String
        String levelName = Level.VIP.name();
        System.out.println(levelName);

        // Konversi String ke enum
        Level level = Level.valueOf("STANDARD");
        System.out.println(level);
        // Level level2 = level.valueOf("SALAH"); // Error

        // Ambil semua variable yang tersedia di enum
        Level[] levels = Level.values();
        for (var value : levels) {
            System.out.println(value);
        }
    }
}
