package belajar_package.application;

import static belajar_package.data.Application.PROCESSORS;
import static belajar_package.data.Constant.*;
import belajar_package.data.Country;
import belajar_package.util.MathUtil;

public class StaticApp {
    public static void main(String[] args) {
        // Mengakses static field
        System.out.println(APPLICATION);
        System.out.println(VERSION);

        // Mengakses static method
        System.out.println(MathUtil.sum(1,1,1,1,1));

        // Mengakses static inner class
        Country.City city = new Country.City();
        city.setName("Bandung");
        System.out.println(city.getName());

        // Static block
        System.out.println(PROCESSORS);
    }
}
