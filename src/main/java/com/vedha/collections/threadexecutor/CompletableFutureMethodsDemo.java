package com.vedha.collections.threadexecutor;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureMethodsDemo {

    public static void main(String[] args) {

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {

            System.out.println("CompletableFuture.runAsync() method");
        });

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {

            return "CompletableFuture.supplyAsync() method";
        });



    }
}
