package com.example.thread;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentMapTest {
    @Test
    void concurrentMap() throws InterruptedException {
        final var countdownLatch = new CountDownLatch(100);
        final var map = new ConcurrentHashMap<Integer, String>();
        final var executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            final var index = i;

            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    map.putIfAbsent(index, "Data " + index);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    countdownLatch.countDown();
                }
            });
        }

        executor.execute(() -> {
            try {
                countdownLatch.await();
                map.forEach((key, value) -> System.out.println(key + " : " + value));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.awaitTermination(5, TimeUnit.SECONDS);

        executor.close();
    }

    @Test
    void testCollection() {
        List<String> fruits = List.of("Apple", "Orange", "Grape", "Mango");
        List<String> synchronizedList = Collections.synchronizedList(fruits);
        System.out.println(synchronizedList);
    }
}
