package com.vedha.collections.threadexecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFactoryDemo implements ThreadFactory {

    AtomicInteger atomicInteger;
    String name;

    ThreadFactoryDemo(String name) {
        this.atomicInteger = new AtomicInteger(0);
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {

        Thread t = new Thread(r, name + "-" + atomicInteger.incrementAndGet());
        t.setPriority(Thread.MAX_PRIORITY);

        return t;
    }

    public static void main(String[] args) throws InterruptedException {

        // Normal Single Thread Executor
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " is running."));
        executorService.shutdown();

        // Default Thread Factory used by Executors class
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        Thread t1 = threadFactory.newThread(() -> System.out.println(Thread.currentThread().getName() + " is running."));
        t1.start();t1.join();

        // Single Thread Executor with Thread Factory to create custom threads with custom names and priorities, etc.
        ThreadFactoryDemo threadFactoryDemo = new ThreadFactoryDemo("custom-thread");
        ExecutorService executorService2 = Executors.newSingleThreadExecutor(threadFactoryDemo);
        executorService2.execute(() -> System.out.println(Thread.currentThread().getName() + " is running."));
        executorService2.shutdown();

        // Single Thread Executor with Thread Factory to create custom threads with custom names and priorities, etc.
        ExecutorService executorService1 = Executors.newSingleThreadExecutor(r -> {
            Thread t = new Thread(r);
            t.setName("Custom Thread");
            t.setPriority(Thread.MAX_PRIORITY);
            return t;

        });
        executorService1.execute(() -> System.out.println(Thread.currentThread().getName() + " is running."));
        executorService1.shutdown();

        // Normal Single Thread Executor
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(() -> System.out.println(Thread.currentThread().getName() + " scheduled is running."), 2, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();

        ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread t = new Thread(r);
            t.setName("Custom Scheduled Thread");
            t.setPriority(Thread.MAX_PRIORITY);
            return t;
        });
        scheduledExecutorService1.schedule(() -> System.out.println(Thread.currentThread().getName() + " is running."), 3, TimeUnit.SECONDS);
        scheduledExecutorService1.shutdown();

        // Custom Thread Pool Executor with Thread Factory to create custom threads with custom names and priorities, etc.
        ThreadFactoryDemo threadFactoryDemo1 = new ThreadFactoryDemo("custom-thread-pool");

        // Custom Thread Pool Executor is used to create a pool of threads and reuse them.
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,  // Core Pool Size
                3, // Max Pool Size
                0L, // Keep Alive Time
                TimeUnit.MILLISECONDS, // Keep Alive Time Unit
                new LinkedBlockingQueue<>(), // Blocking Queue
                threadFactoryDemo1 // Thread Factory
        );

        for (int i = 0; i < 10; i++) {

            threadPoolExecutor.submit(() -> {

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " is running.");
            });
        }

        threadPoolExecutor.shutdown();
    }
}
