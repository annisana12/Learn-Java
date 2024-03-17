package reflection;

import org.junit.jupiter.api.Test;
import reflection.data.Person;

public class SuperClassTest {
    @Test
    void testGetSuperclass() {
        Class<Person> personClass = Person.class;

        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);

        Class<? super Person> parentSuperClass = superclass.getSuperclass();
        System.out.println(parentSuperClass);
    }
}
