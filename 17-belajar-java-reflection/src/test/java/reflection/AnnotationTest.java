package reflection;

import org.junit.jupiter.api.Test;
import reflection.data.Person;
import reflection.validation.Validator;

public class AnnotationTest {
    @Test
    void testValidateUsingAnnotation() throws IllegalAccessException {
        Person person = new Person("Budi", "   ");
        Validator.validateNotBlank(person);
    }
}
