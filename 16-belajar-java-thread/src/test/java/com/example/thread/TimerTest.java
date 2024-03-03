package com.example.thread;

import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    @Test
    void delayedJob() throws InterruptedException {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Delayed Job");
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 2000L);

        // Untuk simulasi di JUnit
        Thread.sleep(3_000L);
    }

    @Test
    void periodicJob() throws InterruptedException {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Delayed Job");
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 2000L, 1000L);

        // Untuk simulasi di JUnit
        Thread.sleep(10_000L);
    }
}
