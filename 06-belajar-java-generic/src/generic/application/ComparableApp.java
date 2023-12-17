package generic.application;

import generic.Person;

import java.util.Arrays;

public class ComparableApp {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Budi", "Jakarta"),
                new Person("Kudo", "Tokyo"),
                new Person("Kim", "Seoul")
        };

        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
    }
}
