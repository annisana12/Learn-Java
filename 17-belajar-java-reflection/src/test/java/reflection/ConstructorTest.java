package reflection;

import org.junit.jupiter.api.Test;
import reflection.data.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ConstructorTest {
    @Test
    void testGetConstructor() {
        Class<Person> personClass = Person.class;
        Constructor<?>[] constructors = personClass.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
            System.out.println(Arrays.toString(constructor.getParameters()));
            System.out.println("=========");
        }
    }

    @Test
    void testCreateObjectFromConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;

        Constructor<Person> constructor = personClass.getDeclaredConstructor();
        Constructor<Person> constructorWithParameter = personClass.getDeclaredConstructor(String.class, String.class);

        Person person1 = constructor.newInstance();
        Person person2 = constructorWithParameter.newInstance("Rudi", "Tabuti");

        System.out.println(person1);
        System.out.println(person2);
    }
}
