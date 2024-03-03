package com.example.thread;

import org.junit.jupiter.api.Test;

public class ThreadTest {
    @Test
    void mainThread() {
        String mainThread = Thread.currentThread().getName();
        System.out.println(mainThread);
    }

    @Test
    void createThread() {
        Runnable runnable = () -> System.out.println("Hello from thread : " + Thread.currentThread().getName());
        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("Program Selesai");
    }

    @Test
    void threadSleep() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000L);
                System.out.println("Hello from thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("Program Selesai");
        Thread.sleep(3_000L);
    }

    @Test
    void threadJoin() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000L);
                System.out.println("Hello from thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("Menunggu Selesai");
        thread.join();

        System.out.println("Program Selesai");
    }

    @Test
    void threadInterrupt() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnable ke " + i);

                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread.sleep(5_000);
        thread.interrupt();

        System.out.println("Menunggu Selesai");
        thread.join();

        System.out.println("Program Selesai");
    }

    @Test
    void threadInterruptCorrect() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                // Manual check interrupted without using sleep
//                if (Thread.interrupted()) {
//                    return;
//                }

                System.out.println("Runnable ke " + i);

                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread.sleep(5_000);
        thread.interrupt();

        System.out.println("Menunggu Selesai");
        thread.join();

        System.out.println("Program Selesai");
    }

    @Test
    void renameThread() {
        Thread thread = new Thread(() -> System.out.println("Thread name : " + Thread.currentThread().getName()));

        thread.setName("Budi");
        thread.start();
    }

    @Test
    void threadState() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getState());
            System.out.println("Thread name : " + Thread.currentThread().getName());
        });

        System.out.println(thread.getState());
        thread.start();

        thread.join();
        System.out.println(thread.getState());
    }
}
