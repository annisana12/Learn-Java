package reflection.validation;

import reflection.annotation.NotBlank;

import java.lang.reflect.Field;

public class Validator {
    public static void validateNotBlank(Object object) throws IllegalAccessException {
        // Get Class
        Class<?> aClass = object.getClass();

        // Get all fields
        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            // Get @NotBlank annotation
            NotBlank notBlank = field.getAnnotation(NotBlank.class);

            // Check if @NotBlank exists
            if (notBlank != null) {
                field.setAccessible(true);

                // Get field value
                String value = (String) field.get(object);

                if (!notBlank.allowEmptyString()) {
                    if (value == null || value.isBlank()) {
                        throw new RuntimeException(field.getName() + " must not blank");
                    }
                }
            }
        }
    }
}
