package com.vedha.collections.threadexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThreadExecutor {

    public static void main(String[] args) throws InterruptedException {

        // Single Virtual Thread Executor
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        executorService.submit(() -> {

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        });


        // Shutdown method is used to initiate an orderly shutdown of the executor service.
        // It will not accept any new tasks but will wait for the already submitted tasks to complete. It is a non-blocking call.
        executorService.shutdown();

//        executorService.close(); // Close method is used to shut down the executor service and release all the resources. It is a blocking call.

        //------------------------------------------------------------------------------------------------------
        // Fixed Virtual Thread Pool
        ThreadFactory factory = Thread.ofVirtual().name("virtual-thread-pool-", 0).factory();
        ExecutorService executorService1 = Executors.newFixedThreadPool(2, factory);

        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 10; i++) {

            executorService1.submit(() -> {
                System.out.println("Atomic Integer: " + atomicInteger.incrementAndGet());
                System.out.println("Thread Name " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService1.shutdown();

//        executorService.close(); // Close method is used to shut down the executor service and release all the resources. It is a blocking call.

        System.out.println("Main Thread Name: " + Thread.currentThread().getName());

        TimeUnit.SECONDS.sleep(6);
    }
}
