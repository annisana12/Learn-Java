package com.example.thread;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    @Test
    void create() {
        var maxThread = 100;
        var minThread = 10;
        var alive = 1;
        var aliveTimeUnit = TimeUnit.MINUTES;
        var queque = new ArrayBlockingQueue<Runnable>(100);

        var threadPool = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTimeUnit, queque);
    }

    @Test
    void executeRunnable() throws InterruptedException {
        var maxThread = 100;
        var minThread = 10;
        var alive = 1;
        var aliveTimeUnit = TimeUnit.MINUTES;
        var queue = new ArrayBlockingQueue<Runnable>(100);

        var threadPool = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTimeUnit, queue);

        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000L);
                System.out.println("Runnable from thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        threadPool.execute(runnable);
        threadPool.execute(runnable);
        threadPool.execute(runnable);

        Thread.sleep(3_000L);
        threadPool.close();
    }

    @Test
    void terminatePool() {
        var maxThread = 100;
        var minThread = 10;
        var alive = 1;
        var aliveTimeUnit = TimeUnit.MINUTES;
        var queue = new ArrayBlockingQueue<Runnable>(1000);

        var threadPool = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTimeUnit, queue);

        for (int i = 0; i < 1000; i++) {
            final var task = i;

            Runnable runnable = () -> {
                try {
                    Thread.sleep(1_000L);
                    System.out.println("Runnable " + task + " from thread : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };

            threadPool.execute(runnable);
        }

        threadPool.shutdown();
        // threadPool.shutdownNow();
        // threadPool.awaitTermination(1, TimeUnit.DAYS);

        threadPool.close();
    }

    @Test
    void rejectedExecutionHandler() throws InterruptedException {
        var maxThread = 100;
        var minThread = 10;
        var alive = 1;
        var aliveTimeUnit = TimeUnit.MINUTES;
        var queue = new ArrayBlockingQueue<Runnable>(10);
        var rejectedHandler = new LogRejectedExecutionHandler();

        var threadPool = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTimeUnit, queue, rejectedHandler);

        for (int i = 0; i < 1000; i++) {
            final var task = i;

            Runnable runnable = () -> {
                try {
                    Thread.sleep(1_000L);
                    System.out.println("Runnable " + task + " from thread : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };

            threadPool.execute(runnable);
        }

        threadPool.awaitTermination(1, TimeUnit.DAYS);
        threadPool.close();
    }

    public static class LogRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task " + r + " is rejected");
        }
    }
}
