package org.example.chapter13;

import java.util.concurrent.*;

public class TestMain13_2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ForkJoinPool executorService = ForkJoinPool.commonPool();

        Future<?> futureRunnable = executorService.submit(() -> System.out.println("not retuning value"));
        Future<String> futureCallable = executorService.submit(() -> "Hello, Async World!");


        CompletableFuture<Void> completableFutureRunnable = CompletableFuture.runAsync(() -> System.out.println("not retuning value"));
        CompletableFuture<String> completableFutureSupplier = CompletableFuture.supplyAsync(() -> "Hello, Async World!");
    }
}
