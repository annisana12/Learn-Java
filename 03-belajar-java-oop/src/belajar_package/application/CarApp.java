package belajar_package.application;

import belajar_package.data.Avanza;
import belajar_package.data.Bus;
import belajar_package.data.Car;

public class CarApp {
    public static void main(String[] args) {
        Car car = new Avanza();
        System.out.println(car.getTire());
        car.drive();
        System.out.println(car.getBrand());
        // System.out.println(car.isMaintenance); // Error karena tipe datanya Car sedangkan isMaintenance adalah method milik Interface IsMaintenance

        Avanza avanza = (Avanza) car;
        System.out.println("Is Avanza on maintenance: " + avanza.isMaintenance());
        System.out.println("Is Avanza big: " + avanza.isBig());

        Car bus = new Bus();
        System.out.println("Is bus big: " + bus.isBig());
    }
}
