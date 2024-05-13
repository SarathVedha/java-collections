package com.vedha.collections.threadexecutor;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedExecutorRead {

    public static void readFiles(URI path) throws IOException {

        List<String> strings = Files.readAllLines(Path.of(path), Charset.defaultCharset());
        strings.forEach(s -> System.out.println(Thread.currentThread().getName() + " : " + path + " : " + s));
    }

    // Thread lifecycle is managed by the executor service
    public static void main(String[] args) throws IOException, InterruptedException {

        List<URI> list = List.of(new ClassPathResource("/files/sample.txt").getURI(), new ClassPathResource("/files/Test.txt").getURI(), new ClassPathResource("/files/Test2.txt").getURI());

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors : " + availableProcessors);

        // Create a fixed thread pool with 2 threads to read the files concurrently
        // it will reuse the threads to read the files concurrently
        ExecutorService executor = Executors.newFixedThreadPool(2);
//        ExecutorService executor = Executors.newFixedThreadPool(availableProcessors);

        // Execute method will accept runnable and execute the task concurrently
        // will not return any result
        list.forEach(file -> executor.execute(() -> {
            try {
                readFiles(file);
                TimeUnit.SECONDS.sleep(2);
            } catch (IOException e) {
                System.out.println("Exception occurred while reading file : " + e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));

        // Shutdown the executor to make sure the program exits
        executor.shutdown();

        // Wait until 2 seconds for all threads to terminate after shutdown request
        // if not terminated, keep waiting for 2 seconds again and again
        while (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
            System.out.println("Waiting for all threads to terminate");
        }

        System.out.println("Finished all threads");
    }
}
