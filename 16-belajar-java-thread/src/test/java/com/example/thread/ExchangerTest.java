package com.example.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerTest {
    @Test
    void test() throws InterruptedException {
        final var exchanger = new Exchanger<String>();
        final var executor = Executors.newFixedThreadPool(10);

        executor.execute(() -> {
            try {
                System.out.println("First thread send: First");
                Thread.sleep(1000);
                var value = exchanger.exchange("Fist");
                System.out.println("First thread receive: " + value);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.execute(() -> {
            try {
                System.out.println("Second thread send: Second");
                Thread.sleep(3000);
                var value = exchanger.exchange("Second");
                System.out.println("Second thread receive: " + value);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.awaitTermination(4, TimeUnit.SECONDS);

        executor.close();
    }
}
