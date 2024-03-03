package com.example.thread;

import org.junit.jupiter.api.Test;

public class ThreadCommunicationTest {
    private String message;
    @Test
    void manual() throws InterruptedException {
        var thread1 = new Thread(() -> {
            while (message == null) {
                // Wait
            }

            System.out.println(message);
        });

        var thread2 = new Thread(() -> {
            message = "Hello";
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    @Test
    void waitNotify() throws InterruptedException {
        final var lock = new Object();

        var thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
                message = "Hello";
                lock.notify();
            }
        });

        thread1.start(); // Pastikan wait start lebih dulu
        thread2.start();

        thread1.join();
        thread2.join();
    }

    @Test
    void waitNotifyAll() throws InterruptedException {
        final var lock = new Object();

        var thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                    System.out.println("Thread1 finished");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        var thread3 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                    System.out.println("Thread3 finished");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
                message = "Hello";
                System.out.println("Thread2 finished");
                lock.notifyAll();
            }
        });

        thread1.start();
        thread3.start();

        thread2.start();

        thread1.join();
        thread3.join();

        thread2.join();
    }
}
