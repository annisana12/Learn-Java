package belajar_package.application;

import belajar_package.data.*;

public class Application {
    public static void main(String[] args) {
        Product product = new Product("Samsung", 5_000_000);
        System.out.println(product.name);
        System.out.println(product.price);

        Data data = new Data();
    }
}
