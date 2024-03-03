package com.example.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    @Test
    void test() throws InterruptedException {
        var countDownLatch = new CountDownLatch(5);
        var executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                try {
                    System.out.println("Start task");
                    Thread.sleep(2000);
                    System.out.println("Finish task");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        executor.execute(() -> {
            try {
                countDownLatch.await();
                System.out.println("All task finish");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.awaitTermination(20, TimeUnit.SECONDS);
        executor.shutdown();

        executor.close();
    }
}
