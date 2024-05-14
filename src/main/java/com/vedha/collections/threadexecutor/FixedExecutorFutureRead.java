package com.vedha.collections.threadexecutor;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FixedExecutorFutureRead {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

        List<URI> lists = List.of(new ClassPathResource("/files/sample.txt").getURI(), new ClassPathResource("/files/Test.txt").getURI(), new ClassPathResource("/files/Test2.txt").getURI());

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors : " + availableProcessors);

        // Create a fixed thread pool with 2 threads to read the files concurrently
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ArrayList<Future<List<String>>> futures = new ArrayList<>(); // List of futures to store the results

        for (URI uri : lists) {
            Future<List<String>> future = executorService.submit(() -> { // Callable lambda to read the file and return the list of line strings as future

                try {
                    System.out.println("Sleeping for 2 Seconds : " + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(2);
                    return Files.readAllLines(Path.of(uri)).stream().map(s -> Thread.currentThread().getName() + " : " + uri + " : " + s).toList(); // Return the list of line strings
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            futures.add(future); // Add the future to the list
        }

        executorService.shutdown(); // Shutdown the executor service
        System.out.println("Shutdown the executor service");

        while (!executorService.awaitTermination(1, TimeUnit.SECONDS)) { // Wait until all threads are terminated
            System.out.println("Waiting for all threads to terminate");
        }

        for (Future<List<String>> f : futures) { // Iterate over the futures

            f.get().forEach(System.out::println); // get method will block until the result is available
        }

        System.out.println("Finished all threads");

        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        Future<?> submit = executorService1.submit(() -> { // Callable lambda to print the message
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + "Hello from the callable");
                }
        );

        executorService1.shutdown(); // Shutdown the executor service after submitting the callable
        Object o = submit.get(); // get method will block until the result is available
        System.out.println(o); // null will be printed as the callable does not return anything

        System.out.println("Main thread finished");
    }
}
