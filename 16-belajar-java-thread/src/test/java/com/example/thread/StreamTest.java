package com.example.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    @Test
    void parallel() {
        Stream<Integer> stream = IntStream.range(0, 1000).boxed();

        stream.parallel().forEach(value -> {
            System.out.println(Thread.currentThread().getName() + " : " + value);
        });
    }

    @Test
    void customPool() {
        var pool = new ForkJoinPool(5);

        pool.execute(() -> {
            Stream<Integer> stream = IntStream.range(0, 1000).boxed();

            stream.parallel().forEach(value -> {
                System.out.println(Thread.currentThread().getName() + " : " + value);
            });
        });

        pool.close();
    }
}
