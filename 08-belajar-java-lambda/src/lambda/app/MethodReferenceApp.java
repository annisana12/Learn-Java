package lambda.app;

import lambda.util.StringUtil;

import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceApp {
    public static void main(String[] args) {
        // Predicate<String> predicateIsLowerCase = value -> StringUtil.isLowerCase(value);
        // Tipe data parameter dan  tipe data return value di util harus sama dengan di interface
        Predicate<String> predicateIsLowerCase = StringUtil::isLowerCase;

        System.out.println(predicateIsLowerCase.test("budi"));
        System.out.println(predicateIsLowerCase.test("Budi"));

        MethodReferenceApp app = new MethodReferenceApp();
        Predicate<String> test = app::isLowerCase;

        // Function<String, String> functionUpperCase = s -> s.toUpperCase();
        Function<String, String> functionUpperCase = String::toUpperCase;

        System.out.println(functionUpperCase.apply("budi"));
    }

    public void run() {
        // Predicate<String> predicateIsLowerCase = MethodReferenceApp.this::isLowerCase;
        Predicate<String> predicateIsLowerCase = this::isLowerCase;
    }

    public void run2() {
        // Misalkan isLowerCase ada di object lain
        MethodReferenceApp app = new MethodReferenceApp();
        Predicate<String> predicateIsLowerCase2 = app::isLowerCase;
    }

    public boolean isLowerCase(String value) {
        for (var c : value.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }

        return true;
    }
}
