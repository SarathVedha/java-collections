package com.vedha.collections.threadexecutor;

import java.util.concurrent.*;

public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // RunAsync
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {

            // Run a task specified by a Runnable Object asynchronously. Non-blocking call
            try {
                System.out.println("Sleeping for 2 Seconds : " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("I am From RunAsync Method: " + Thread.currentThread().getName());
        }, executorService);// it is a non-blocking call

        executorService.shutdown();

        voidCompletableFuture.thenAccept(unused -> System.out.println("Task Completed")); // it is not a blocking call

        System.out.println("Main Thread Called"); // it will be printed before the result of the CompletableFuture

        TimeUnit.SECONDS.sleep(3);


        // SupplyAsync
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);

        // Run a task specified by a Runnable Object asynchronously. Non-blocking call
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            // supplyAsync is used to run a task asynchronously and return a result,
            // runAsync is used to run a task asynchronously and return nothing

            try {
                System.out.println("Sleeping for 2 Seconds : " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return "I am From SupplyAsync Method: " + Thread.currentThread().getName();
        }, executorService1);

        executorService1.shutdown();

        stringCompletableFuture.thenAccept(s -> System.out.println("Result is: " + s)); // it is not a blocking call

        System.out.println("Main Thread Completed"); // it will be printed before the result of the CompletableFuture
    }
}
