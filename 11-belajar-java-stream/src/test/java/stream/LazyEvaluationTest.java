package stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class LazyEvaluationTest {

    @Test
    public void testIntermediateOperation() {
        List<String> names = List.of("Eko", "Joko", "Dwi");

        Stream<String> upper = names.stream().map(name -> {
            System.out.println("Change " + name + " to uppercase");
           return name.toUpperCase();
        });
    }

    @Test
    public void testTerminalOperation() {
        List<String> names = List.of("Eko", "Joko", "Dwi");

        names.stream()
                .map(name -> {
                    System.out.println("Change " + name + " to uppercase");
                    return name.toUpperCase();
                })
                .map(upper -> {
                    System.out.println("Add Mr. to " + upper);
                    return "Mr. " + upper;
                })
                .forEach(System.out::println);
    }
}
