package ru.otus.multiT;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CustomThreadPoolExecutor threadPool = new CustomThreadPoolExecutor(8);
        Counter counter = new Counter();

        long start = System.nanoTime();

        List<Future<Double>> futures = new ArrayList<>();
        for (int i = 0; i < 400; i++) {
            final int j = i;
            futures.add(
                    CompletableFuture.supplyAsync(
                            () -> counter.count(j),
                            threadPool
                    ));
        }
        System.out.println("ALL TASKS LOADED");

        double value = 0;
        for (Future<Double> future : futures) {
            value += future.get();
        }

        System.out.printf("Executed by %d s, value : %f%n",
                (System.nanoTime() - start) / (1000_000_000),
                value);

        threadPool.shutdown();
    }
}