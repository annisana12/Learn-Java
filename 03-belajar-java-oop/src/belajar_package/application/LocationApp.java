package belajar_package.application;

import belajar_package.data.City;

public class LocationApp {
    public static void main(String[] args) {
        // Location location = new Location(); // Error
        City city = new City();
        city.name = "Jakarta";
        System.out.println(city.name);
    }
}
