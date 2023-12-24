package test;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

@DisplayName("A Queue")
public class QueueTest {
    private Queue<String> queue;

    @Nested
    @DisplayName("when new")
    public class WhenNew {
        @BeforeEach
        void setUp() {
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("when offer 1 data, size must be 1")
        public void offerNewData() {
            queue.offer("Budi");
            Assertions.assertEquals(1, queue.size());
        }

        @Test
        @DisplayName("when offer 2 data, size must be 2")
        public void offerMoreData() {
            queue.offer("Budi");
            queue.offer("Joko");
            Assertions.assertEquals(2, queue.size());
        }
    }
}
