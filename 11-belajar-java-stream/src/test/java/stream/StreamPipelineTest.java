package stream;

import org.junit.jupiter.api.Test;

import java.util.List;

public class StreamPipelineTest {

    @Test
    public void testStreamPipeline() {
        List<String> list = List.of("Budi", "Joko", "Eko", "Dwi");

        list.stream()
                .map(String::toUpperCase)
                .map(upper -> "Mr. " + upper)
                .forEach(System.out::println);
    }
}
