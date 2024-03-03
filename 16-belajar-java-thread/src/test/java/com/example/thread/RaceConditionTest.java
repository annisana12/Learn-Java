package com.example.thread;

import org.junit.jupiter.api.Test;

public class RaceConditionTest {
    @Test
    void testCounter() throws InterruptedException {
        var counter = new Counter();

        Runnable runnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(counter.getValue());
    }
}
