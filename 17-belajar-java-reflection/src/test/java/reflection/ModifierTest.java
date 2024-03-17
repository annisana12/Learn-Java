package reflection;

import org.junit.jupiter.api.Test;
import reflection.data.Person;

import java.lang.reflect.Modifier;

public class ModifierTest {
    @Test
    void testModifier() {
        Class<Person> personClass = Person.class;
        int modifiers = personClass.getModifiers();

        System.out.println(Modifier.isPublic(modifiers));
        System.out.println(Modifier.isFinal(modifiers));
        System.out.println(Modifier.isStatic(modifiers));
    }
}
