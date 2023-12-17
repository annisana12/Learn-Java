package belajar_package.data;

import java.util.Objects;

public class Product {
    public String name;
    public int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // Override toString method
    public String toString() {
        return "Product name: " + name + ", Price: " + price;
    }

    // Override equals method
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (price != product.price) return false;
        return Objects.equals(name, product.name);
    }

    //    public boolean equals(Object o) {
//        // Jika lokasi di memori sama
//        if (o == this) {
//            return true;
//        }
//
//        if (!(o instanceof Product)) {
//            return false;
//        }
//
//        Product product = (Product) o;
//
//        if (product.price != this.price) {
//            return false;
//        }
//
//        if (this.name != null) {
//            return this.name.equals(product.name);
//        } else {
//            return product.name == null;
//        }
//    }

    // Override hashCode method
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + price;
        return result;
    }
}
