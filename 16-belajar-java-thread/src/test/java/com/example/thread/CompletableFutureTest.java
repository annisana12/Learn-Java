package com.example.thread;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class CompletableFutureTest {
    private ExecutorService executor = Executors.newFixedThreadPool(10);
    private Random random = new Random();

    public CompletableFuture<String> getValue() {
        CompletableFuture<String> future = new CompletableFuture<>();

        executor.execute(() -> {
            try {
                Thread.sleep(2000);
                future.complete("Belajar Java Thread");
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        });

        return future;
    }

    @Test
    void create() throws ExecutionException, InterruptedException {
        Future<String> future = getValue();
        System.out.println(future.get());
    }

    public void execute(CompletableFuture<String> completableFuture, String value) {
        executor.execute(() -> {
            try {
                Thread.sleep(1000 + random.nextInt(5000));
                completableFuture.complete(value);
            } catch (InterruptedException e) {
                completableFuture.completeExceptionally(e);
            }
        });
    }

    public Future<String> getFastest() {
        CompletableFuture<String> future = new CompletableFuture<>();

        execute(future, "Thread 1");
        execute(future, "Thread 2");
        execute(future, "Thread 3");

        return future;
    }

    @Test
    void testFastest() throws ExecutionException, InterruptedException {
        System.out.println(getFastest().get());
    }

    @Test
    void testCompletionStage() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = getValue();

        CompletableFuture<String[]> future2 = future.thenApply(String::toUpperCase)
                .thenApply(string -> string.split(" "));

        String[] strings = future2.get();

        for (var value : strings) {
            System.out.println(value);
        }
    }
}
