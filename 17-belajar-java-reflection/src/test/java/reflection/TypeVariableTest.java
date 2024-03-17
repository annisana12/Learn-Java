package reflection;

import org.junit.jupiter.api.Test;
import reflection.data.Data;

import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class TypeVariableTest {
    @Test
    void testGetTypeVariable() {
        Class<Data> dataClass = Data.class;

        TypeVariable<Class<Data>>[] typeParameters = dataClass.getTypeParameters();

        for (TypeVariable<Class<Data>> parameter : typeParameters) {
            System.out.println(parameter.getName());
            System.out.println(Arrays.toString(parameter.getBounds()));
            System.out.println(parameter.getGenericDeclaration());
        }
    }
}
