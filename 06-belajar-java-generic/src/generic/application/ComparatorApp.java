package generic.application;

import generic.Person;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorApp {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Budi", "Jakarta"),
                new Person("Kudo", "Tokyo"),
                new Person("Kim", "Seoul")
        };

        // Misalkan Person tidak implements Comparable
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Arrays.sort(people, comparator);
        System.out.println(Arrays.toString(people));
    }
}
