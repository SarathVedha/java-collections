package com.vedha.collections.threadexecutor;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.*;

public class CompletableFutureRead {

    public static void main(String[] args) throws IOException {

        List<URI> list = List.of(new ClassPathResource("/files/sample.txt").getURI(), new ClassPathResource("/files/Test.txt").getURI(), new ClassPathResource("/files/Test2.txt").getURI());

        // Create a fixed thread pool with 2 threads to read the files concurrently
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Create a list of completable futures to store the results
        List<CompletableFuture<List<String>>> completableFutureList = list.stream().map(uri -> {

            // Run a task specified by a Supplier Object asynchronously. Non-blocking call
            CompletableFuture<List<String>> listCompletableFuture = CompletableFuture.supplyAsync(() -> {
                // supplyAsync is used to run a task asynchronously and return a result,
                // runAsync is used to run a task asynchronously and return nothing

                try {
                    System.out.println("Sleeping for 2 Seconds : " + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(2);
                    return Files.readAllLines(Path.of(uri)).stream().map(s -> Thread.currentThread().getName() + " : " + uri + " : " + s).toList();
                } catch (InterruptedException | IOException e) {
                    throw new RuntimeException(e);
                }
            }, executorService);

            return listCompletableFuture;
        }).toList();

        // Shutdown the executor service
        executorService.shutdown();

        // Wait until all threads are terminated, but it is not blocking
        // CompletableFuture.allOf() method returns a new CompletableFuture that is completed when all the given CompletableFutures complete.
        // Return CompletableFuture<Void>
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]));

        // Run a task specified by a Consumer Object asynchronously. Non-blocking call
        voidCompletableFuture.thenAccept(unused -> {
            for (CompletableFuture<List<String>> completableFuture : completableFutureList) { // Using for-each loop to iterate over the completable futures

                System.out.println("CompletableFuture.join() : " + Thread.currentThread().getName());
                // diff between get() and join() is that join() does not throw checked exceptions
                // join() is a non-blocking call and does not throw checked exceptions
                // get() is a blocking call and throws checked exceptions
                // you can use join() if you are sure that the completable future will complete successfully
                List<String> strings = completableFuture.join(); // you can use both join() or get() here because allOf() method is already completed.
                strings.forEach(System.out::println);
            }
        });

        // The Main Thread will not wait for the result of the completable future
        System.out.println("Main Thread Finished: " + Thread.currentThread().getName());
    }
}
