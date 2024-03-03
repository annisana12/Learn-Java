package com.example.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

public class ExecutorServiceTest {
    @Test
    void testExecutorService() {
        var executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Runnable in Thread: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
        executor.close();
    }

    @Test
    void testExecutorServiceFix() {
        var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            var count = i;

            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Runnable " + count + " in Thread: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
        executor.close();
    }
}
