package com.example.thread;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FutureTest {
    @Test
    void testFuture() throws ExecutionException, InterruptedException {
        var executor = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {
            Thread.sleep(5000);
            return "Hi";
        };

        Future<String> future = executor.submit(callable);
        System.out.println("Callable start running");

        while (!future.isDone()) {
            System.out.println("Waiting future");
            Thread.sleep(1000);
        }

        String value = future.get(); // Blocking
        System.out.println(value);

        executor.close();
    }

    @Test
    void testFutureCancel() throws ExecutionException, InterruptedException {
        var executor = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {
            Thread.sleep(5000);
            return "Hi";
        };

        Future<String> future = executor.submit(callable);
        System.out.println("Callable start running");

        Thread.sleep(2000);
        future.cancel(true);
        System.out.println(future.isCancelled());

        executor.close();
    }

    @Test
    void invokeAll() throws InterruptedException, ExecutionException {
        var executor = Executors.newFixedThreadPool(10);

        List<Callable<String>> callables = IntStream.range(1, 11).mapToObj((IntFunction<Callable<String>>) value -> () -> {
            Thread.sleep(value * 500L);
            return String.valueOf(value);
        }).toList();

        List<Future<String>> futures = executor.invokeAll(callables);

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        executor.close();
    }

    @Test
    void invokeAny() throws InterruptedException, ExecutionException {
        var executor = Executors.newFixedThreadPool(10);

        List<Callable<String>> callables = IntStream.range(1, 11).mapToObj((IntFunction<Callable<String>>) value -> () -> {
            Thread.sleep(value * 500L);
            return String.valueOf(value);
        }).toList();

        String result = executor.invokeAny(callables);
        System.out.println(result);

        executor.close();
    }
}
