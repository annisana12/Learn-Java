package stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class CreateStreamBuilderTest {

    @Test
    public void testCreateStreamBuilder() {
        Stream.Builder<String> builder = Stream.builder();

        builder.accept("Apple");
        builder.add("Orange").add("Mango");

        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);
    }

    @Test
    public void testCreateStreamBuilderSimplify() {
        Stream<String> stream = Stream.<String>builder()
                .add("Apple").add("Mango").add("Orange")
                .build();

        stream.forEach(System.out::println);
    }
}
