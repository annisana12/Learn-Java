package com.example.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore digunakan untuk membatasi jumlah task yang dieksekusi dalam satu waktu
 * Misal membatasi jumlah request yang dikirim ke aplikasi lain
 */
public class SemaphoreTest {
    @Test
    void test() throws InterruptedException {
        final var semaphore = new Semaphore(1);
        final var executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 1000; i++) {
            executor.execute(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(1000);
                    System.out.println("Finish");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }
            });
        }

        executor.awaitTermination(1000, TimeUnit.SECONDS);
        executor.shutdown();

        executor.close();
    }
}
