package reflection;

import org.junit.jupiter.api.Test;
import reflection.data.Person;

import java.lang.reflect.Field;

public class FieldTest {
    @Test
    void testGetFields() {
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();

        for (Field field : declaredFields) {
            System.out.println(field.getName() + " : " + field.getType().getName());
        }
    }

    @Test
    void testGetFieldValue() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true);

        Person person1 = new Person("Budi", "Nugraha");
        String result = firstName.get(person1).toString();
        System.out.println(result);
    }

    @Test
    void testSetFieldValue() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true);

        Person person1 = new Person("Budi", "Nugraha");
        System.out.println("Old firstName : " + person1.getFirstName());

        firstName.set(person1, "Joko");
        System.out.println("New FirstName : " + person1.getFirstName());
    }
}
