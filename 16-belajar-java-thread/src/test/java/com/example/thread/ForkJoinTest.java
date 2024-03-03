package com.example.thread;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ForkJoinTest {
    @Test
    void create() {
        var forkJoinPool1 = ForkJoinPool.commonPool(); // Sejumlah core CPU
        var forkJoinPool2 = new ForkJoinPool(5);

        var executor1 = Executors.newWorkStealingPool();
        var executor2 = Executors.newWorkStealingPool(5);
    }

    @Test
    void recursiveAction() throws InterruptedException {
        var pool = new ForkJoinPool(5);
        List<Integer> integers = IntStream.range(0, 1000).boxed().toList();

        var task = new SimpleForkJoinTask(integers);
        pool.execute(task);

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);

        pool.close();
    }

    @Test
    void recursiveTask() throws InterruptedException, ExecutionException {
        var pool = new ForkJoinPool(5);
        List<Integer> integers = IntStream.range(0, 1000).boxed().toList();

        var task = new TotalRecursiveTask(integers);
        ForkJoinTask<Long> result = pool.submit(task);

        System.out.println("Result : " + result.get());

        var sum = integers.stream().mapToLong(value -> value).sum();
        System.out.println("Expected result : " + sum);

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);

        pool.close();
    }

    public static class SimpleForkJoinTask extends RecursiveAction {

        private List<Integer> integers ;

        public SimpleForkJoinTask(List<Integer> integers) {
            this.integers = integers;
        }

        @Override
        protected void compute() {
            if (integers.size() <= 10) {
                doExecute();
            } else {
                forkCompute();
            }
        }

        private void forkCompute() {
            List<Integer> integers1 = integers.subList(0, integers.size() / 2);
            List<Integer> integers2 = integers.subList(integers.size() / 2, integers.size());

            SimpleForkJoinTask task1 = new SimpleForkJoinTask(integers1);
            SimpleForkJoinTask task2 = new SimpleForkJoinTask(integers2);

            ForkJoinTask.invokeAll(task1, task2);
        }

        private void doExecute() {
            integers.forEach(value -> System.out.println(Thread.currentThread().getName() + " : " + value));
        }
    }

    public static class TotalRecursiveTask extends RecursiveTask<Long> {
        private List<Integer> integers ;

        public TotalRecursiveTask(List<Integer> integers) {
            this.integers = integers;
        }

        @Override
        protected Long compute() {
            if (integers.size() <= 10) {
                return doCompute();
            } else {
                 return forkCompute();
            }
        }

        private Long forkCompute() {
            List<Integer> integers1 = integers.subList(0, integers.size() / 2);
            List<Integer> integers2 = integers.subList(integers.size() / 2, integers.size());

            TotalRecursiveTask task1 = new TotalRecursiveTask(integers1);
            TotalRecursiveTask task2 = new TotalRecursiveTask(integers2);

            ForkJoinTask.invokeAll(task1, task2);
            return task1.join() + task2.join();
        }

        private Long doCompute() {
            return integers.stream().mapToLong(value -> value).peek(value -> {
                System.out.println(Thread.currentThread().getName() + " : " + value);
            }).sum();
        }
    }
}
