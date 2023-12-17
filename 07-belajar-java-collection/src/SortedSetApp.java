import data.Person;
import data.PersonComparator;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetApp {
    public static void main(String[] args) {
        SortedSet<Person> people = new TreeSet<>(new PersonComparator()); // ASC
        // SortedSet<Person> people = new TreeSet<>(new PersonComparator().reversed()); // DESC

        people.add(new Person("Joko"));
        people.add(new Person("Budi"));
        people.add(new Person("Bunga"));

        for (var person : people) {
            System.out.println(person.getName());
        }

        SortedSet<Person> sortedSet = Collections.unmodifiableSortedSet(people);
        // sortedSet.add(new Person("Eko")); error
    }
}
