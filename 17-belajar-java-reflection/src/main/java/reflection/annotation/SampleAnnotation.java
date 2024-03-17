package reflection.annotation;

import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PACKAGE)
public @interface SampleAnnotation {
}
