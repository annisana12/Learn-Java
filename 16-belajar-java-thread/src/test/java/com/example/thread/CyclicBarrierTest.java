package com.example.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {
    @Test
    void test() throws InterruptedException {
        final var cyclicBarrier = new CyclicBarrier(5);
        final var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                try {
                    System.out.println("waiting");
                    cyclicBarrier.await();
                    System.out.println("finish waiting");
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdown();

        executor.close();
    }
}
