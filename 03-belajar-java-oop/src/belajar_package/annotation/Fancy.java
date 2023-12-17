package belajar_package.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Annotation fungsinya untuk menambahkan metadata
@Target({ElementType.TYPE}) // Bisa diterapkan di class, interface, record, enum
@Retention(RetentionPolicy.RUNTIME)
public @interface Fancy {
    // Attributes di annotation
    String name(); // Wajib di set saat Fancy di panggil
    String[] tags() default {}; // Saat manggil annotation Fancy, nggak wajib set tags
}
