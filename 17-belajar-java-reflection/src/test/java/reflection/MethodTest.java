package reflection;

import org.junit.jupiter.api.Test;
import reflection.data.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodTest {
    @Test
    void testGetMethod() {
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(Arrays.toString(method.getParameters()));
            System.out.println(Arrays.toString(method.getParameterTypes()));
            System.out.println(Arrays.toString(method.getExceptionTypes()));
            System.out.println("==============");
        }
    }

    @Test
    void testInvokeMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method getFirstName = personClass.getDeclaredMethod("getFirstName");

        Person person = new Person("Budi", "Nugraha");
        String result = (String) getFirstName.invoke(person);
        System.out.println(result);
    }
}
