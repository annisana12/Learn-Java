package com.example.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ThreadLocalRandomTest {
    @Test
    void testRandom() throws InterruptedException {
        final var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    var number = ThreadLocalRandom.current().nextInt();
                    System.out.println(number);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.awaitTermination(5, TimeUnit.SECONDS);
        executor.close();
    }

    @Test
    void stream() throws InterruptedException {
        final var executor = Executors.newFixedThreadPool(10);

        executor.execute(() -> {
            ThreadLocalRandom.current().ints(1000, 0, 1000)
                    .forEach(System.out::println);
        });

        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.close();
    }
}
