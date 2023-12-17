package belajar_package.application;

import belajar_package.annotation.Fancy;
import belajar_package.data.Animal;
import belajar_package.data.Cat;

@Fancy(name = "AnimalApp", tags = {"Application", "Java"})
public class AnimalApp {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.name = "Meow";
        cat.run();
    }
}
