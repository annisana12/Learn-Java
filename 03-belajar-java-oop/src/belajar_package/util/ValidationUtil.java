package belajar_package.util;

import belajar_package.annotation.NotBlank;
import belajar_package.data.LoginRequest;
import belajar_package.error.BlankException;
import belajar_package.error.ValidationException;

import java.lang.reflect.Field;
import java.util.Objects;

public class ValidationUtil {
    public static void validate(LoginRequest loginRequest) throws ValidationException, NullPointerException {
        if (loginRequest.username() == null) {
            throw new NullPointerException("Username is null");
        } else if (loginRequest.username().isBlank()) {
            throw new ValidationException("Username is blank");
        } else if (loginRequest.password() == null) {
            throw new NullPointerException("Password is null");
        } else if (loginRequest.password().isBlank()) {
            throw new ValidationException("Password is blank");
        }
    }

    // Tidak wajib pakai throws kalau runtimeException
    public static void validateRuntime(LoginRequest loginRequest) {
        if (loginRequest.username() == null) {
            throw new NullPointerException("Username is null");
        } else if (loginRequest.username().isBlank()) {
            throw new BlankException("Username is blank");
        } else if (loginRequest.password() == null) {
            throw new NullPointerException("Password is null");
        } else if (loginRequest.password().isBlank()) {
            throw new BlankException("Password is blank");
        }
    }

    public static void validationReflection(Object object) {
        Class aClass = object.getClass(); // Get class dari object menggunakan reflection
        Field[] fields = aClass.getDeclaredFields(); // get semua field dari public sampai private

        for (var field : fields) {
            // Set field private jadi bisa diakses
            field.setAccessible(true);

            // Jika field ada annotation NotBlank
            if (field.getAnnotation(NotBlank.class) != null) {
                // Validasi field
                try {
                    String value = (String) field.get(object);

                    if (value == null || value.isBlank()) {
                        throw new BlankException("Field " + field.getName() + " is blank");
                    }
                } catch (IllegalAccessException exception) {
                    System.out.println("Tidak dapat mengakses field: " + field.getName());
                }
            }
        }
    }
}
