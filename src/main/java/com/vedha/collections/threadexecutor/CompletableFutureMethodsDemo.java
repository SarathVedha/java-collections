package com.vedha.collections.threadexecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureMethodsDemo {

    public static void main(String[] args) {

        // runAsync() method no return value
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> System.out.println("CompletableFuture.runAsync() method: " + Thread.currentThread().getName()));

        // supplyAsync() method with return value
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "CompletableFuture.supplyAsync() method: " + Thread.currentThread().getName());

        // thenAccept method is used to process the result of the previous stage
        stringCompletableFuture.thenAccept(s -> {

            System.out.println("CompletableFuture.thenAcceptAsync() method: " + Thread.currentThread().getName());
            System.out.println(s);
        });

        // theApply method is used to process the result of the previous stage and return a new CompletableFuture
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> 2 + 3);
        CompletableFuture<Integer> integerCompletableFuture1 = integerCompletableFuture.thenApply(integer -> integer + 5);

        // thenApply and thenAccept method
        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.supplyAsync(() -> 2 + 3).thenApply(integer -> integer + 5).thenAccept(integer -> System.out.println("CompletableFuture.thenApply() method: " + integer));

        // thenCombine method is used to combine the results of two CompletableFutures
        CompletableFuture<Integer> integerCompletableFuture2 = CompletableFuture.supplyAsync(() -> 10 * 2);
        CompletableFuture<Integer> integerCompletableFuture3 = CompletableFuture.supplyAsync(() -> 20 * 2);
        CompletableFuture<Void> voidCompletableFuture2 = integerCompletableFuture2.thenCombine(integerCompletableFuture3, Integer::sum).thenAccept(integer -> System.out.println("CompletableFuture.thenCombine() method: " + integer));

        CompletableFuture<String> stringCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("Testing Exception");
            } else {
                return "No exception occurred";
            }
        });

        // exceptionally method is used to handle the exception occurred in the previous stage and return a new value or result
        CompletableFuture<String> exceptionally = stringCompletableFuture1.exceptionally(throwable -> {
            System.out.println("CompletableFuture.exceptionally() method: " + throwable.getMessage());
            return "Exception occurred: " + throwable.getMessage();

        });

        // completeOnTimeout method is used to complete the CompletableFuture with a default value if the result is not available within the specified time
        CompletableFuture<Integer> integerCompletableFuture4 = CompletableFuture.supplyAsync(() -> {

            try {
                System.out.println("Sleeping for 3 seconds");
                TimeUnit.SECONDS.sleep(3);
                return 2 + 3;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).completeOnTimeout(0, 1, TimeUnit.SECONDS); // default value is 0, timeout is 1 second


        CompletableFuture<String> stringCompletableFuture2 = CompletableFuture.supplyAsync(() -> {

            try {
                TimeUnit.SECONDS.sleep(2);
                return "Cancelled CompletableFuture";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        boolean cancel = stringCompletableFuture2.cancel(true);
        System.out.println("CompletableFuture.cancel() method: " + cancel);

        // thenCompose method is used to combine the results of two CompletableFutures
        CompletableFuture<Void> voidCompletableFuture3 = CompletableFuture.supplyAsync(() -> 2 * 5).thenApply(integer -> integer + 5).thenCompose(integer -> integer == 15 ? CompletableFuture.completedFuture(integer) : CompletableFuture.completedFuture(0)).thenAccept(integer -> System.out.println("CompletableFuture.thenCompose() method: " + integer));


        // Pipeline of CompletableFutures
        CompletableFuture<Void> voidCompletableFuture4 = CompletableFuture.supplyAsync(() -> 2 + 3).thenApply(integer -> integer + 5).thenCombine(CompletableFuture.supplyAsync(() -> 10 * 2), Integer::sum).thenApply(integer -> {

            if (integer == 30) { // 30 is the result of the previous stage then throw an exception
                throw new RuntimeException("Testing Exception in Pipeline");
            } else {
                return integer;
            }
        }).exceptionally(throwable -> {
            System.out.println("CompletableFuture Pipeline Exception: " + throwable.getMessage());
            return -1;
        }).thenAccept(integer -> System.out.println("CompletableFuture Pipeline: " + integer));

        // allOf method is used to wait for the completion of all the CompletableFutures
        CompletableFuture.allOf(voidCompletableFuture, stringCompletableFuture, integerCompletableFuture1, voidCompletableFuture1, voidCompletableFuture2, exceptionally, integerCompletableFuture4, voidCompletableFuture3, voidCompletableFuture4).join();

        Void join = voidCompletableFuture.join();
        System.out.println(join);

        String join2 = stringCompletableFuture.join();
        System.out.println(join2);

        Integer join3 = integerCompletableFuture1.join();
        System.out.println(join3);

        String join1 = exceptionally.join();
        System.out.println(join1);

        Integer join4 = integerCompletableFuture4.join();
        System.out.println(join4);

        System.out.println("Main Thread: " + Thread.currentThread().getName());
    }
}
