package com.vedha.collections.threadexecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableFuture {

    public static Double getPrice(String stock) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("Error in thread sleep");
        }

        System.out.println(Thread.currentThread().getName() + " : Calculating price for stock: " + stock);
        return Math.random() * 1000;
    }

    public static void main(String[] args) {

        List<Future> futures = new ArrayList<>();
        List<String> stocks = List.of("AAPL", "GOOG", "AMZN", "TSLA", "MSFT");

        // Fixed thread pool with 2 threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (String stock : stocks) {

            // Callable interface is implemented using lambda expression
            // submit() method is used to submit the task to the executor, and it returns a Future object
            Future<Double> future = executorService.submit(() -> getPrice(stock));

            System.out.println("Price of stock: " + stock + " is: " + future); // This will print the future object

            futures.add(future);
        }

        executorService.shutdown(); // This will not shut down the executor immediately, it will wait for all the tasks to complete

        for (Future future : futures) {
            try {
                System.out.println("Price of stock: " + future.get()); // get() method will block the thread until the result is available
                System.out.println("Future : " + future);
            } catch (Exception e) {
                System.out.println("Error in getting price");
            }
        }

    }
}
