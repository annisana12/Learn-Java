package stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class ForEachOperationTest {

    @Test
    void testWithoutPeek() {
        Stream.of("Budi", "Eko", "Joko", "Dwi")
                .map(name -> {
                    System.out.println("Before change name to upper : " + name);
                    var result = name.toUpperCase();
                    System.out.println("After change name to upper : " + result);
                    return result;
                })
                .forEach(upper -> System.out.println("Final result : " + upper));
    }

    @Test
    void testWithPeek() {
        Stream.of("Budi", "Eko", "Joko", "Dwi")
                .peek(name -> System.out.println("Before change name to upper : " + name))
                .map(String::toUpperCase)
                .peek(upper -> System.out.println("After change name to upper : " + upper))
                .forEach(result -> System.out.println("Final result : " + result));
    }
}
