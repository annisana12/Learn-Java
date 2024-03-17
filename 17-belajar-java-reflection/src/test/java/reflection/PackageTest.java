package reflection;

import org.junit.jupiter.api.Test;
import reflection.data.Person;

import java.util.Arrays;

public class PackageTest {
    @Test
    void testGetPackage() {
        Class<Person> personClass = Person.class;
        Package aPackage = personClass.getPackage();

        System.out.println(aPackage.getName());
        System.out.println(Arrays.toString(aPackage.getDeclaredAnnotations()));
    }
}
