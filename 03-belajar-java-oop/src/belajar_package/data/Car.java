package belajar_package.data;

import belajar_package.annotation.Fancy;

/**
 * Belajar interface
 */
@Fancy(name = "Car")
public interface Car extends HasBrand {
    // Secara default, method ini setara dengan public abstract void drive();
    void drive();

    int getTire();

    /**
     * Default abstract method
     * Tidak wajib di override
     * Baru ada di Java 8
     */
    default boolean isBig() {
        return false;
    }
}
