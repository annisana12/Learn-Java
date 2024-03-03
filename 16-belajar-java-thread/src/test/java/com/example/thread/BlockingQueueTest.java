package com.example.thread;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.concurrent.*;

public class BlockingQueueTest {
    @Test
    void arrayBlockingQueue() throws InterruptedException {
        final var queue = new ArrayBlockingQueue<String>(5);
        final var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            final var index = i;

            executor.execute(() -> {
                try {
                    queue.put("Data " + index);
                    System.out.println("Finish put Data " + index);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println(value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.awaitTermination(20, TimeUnit.SECONDS);

        executor.close();
    }

    @Test
    void linkedBlockingQueue() throws InterruptedException {
        final var queue = new LinkedBlockingQueue<String>();
        final var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            final var index = i;

            executor.execute(() -> {
                try {
                    queue.put("Data " + index);
                    System.out.println("Finish put Data " + index);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println(value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.awaitTermination(20, TimeUnit.SECONDS);

        executor.close();
    }

    @Test
    void priorityBlockingQueue() throws InterruptedException {
        final var queue = new PriorityBlockingQueue<Integer>(10, Comparator.reverseOrder());
        final var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            final var index = i;

            executor.execute(() -> {
                queue.put(index);
                System.out.println("Finish put data : " + index);
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println(value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.awaitTermination(20, TimeUnit.SECONDS);

        executor.close();
    }

    @Test
    void delayQueue() throws InterruptedException {
        final var queue = new DelayQueue<ScheduledFuture<String>>();
        final var executor = Executors.newFixedThreadPool(10);
        final var scheduledExecutor = Executors.newScheduledThreadPool(10);

        for (int i = 0; i < 10; i++) {
            final var index = i;

            executor.execute(() -> {
                queue.put(scheduledExecutor.schedule(() -> "Data " + index, index, TimeUnit.SECONDS));
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    var value = queue.take();
                    System.out.println(value.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.awaitTermination(20, TimeUnit.SECONDS);

        executor.close();
    }

    @Test
    void synchronizedQueue() throws InterruptedException {
        final var queue = new SynchronousQueue<String>();
        final var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final var index = i;

            executor.execute(() -> {
                try {
                    queue.put("Data " + index);
                    System.out.println("Finish put Data " + index);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println(value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.awaitTermination(20, TimeUnit.SECONDS);

        executor.close();
    }

    @Test
    void transferQueue() throws InterruptedException {
        final var queue = new LinkedTransferQueue<String>();
        final var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final var index = i;
            
            executor.execute(() -> {
                try {
                    queue.transfer("Data " + index);
                    System.out.println("Finish put Data " + index);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println(value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.awaitTermination(20, TimeUnit.SECONDS);

        executor.close();
    }

    @Test
    void blockingDeque() throws InterruptedException {
        final var queue = new LinkedBlockingDeque<String>();
        final var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final var index = i;
            queue.putLast("Data " + index);
            System.out.println("Finish put Data " + index);
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.takeLast();
                    System.out.println(value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.awaitTermination(20, TimeUnit.SECONDS);

        executor.close();
    }
}
