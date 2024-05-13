package com.vedha.collections.threadexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadExecutor {

    public static void main(String[] args) throws InterruptedException {

        // Task to run after 2 seconds one time
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.schedule(() -> System.out.println("ScheduledExecutorService: Executed after 2 seconds"), 2, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();


        // Task to run repeatedly every 2 seconds with an initial delay of second 3
        ScheduledExecutorService scheduledExecutorService1 = Executors.newScheduledThreadPool(3);
        scheduledExecutorService1.scheduleAtFixedRate(() -> {
            System.out.println("ScheduledExecutorService1: Executed second: " + (System.currentTimeMillis() / 1000));
            try {
                TimeUnit.SECONDS.sleep(3); // Simulating a long-running task with 3 seconds will cause the task to be executed every 3 seconds
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 3, 2, TimeUnit.SECONDS); // Initial delay of 3 seconds and then executed every 2 seconds

        TimeUnit.SECONDS.sleep(10);
        scheduledExecutorService1.shutdown();
        scheduledExecutorService1.shutdownNow();
        System.out.println("scheduledExecutorService1 all tasks to complete");


        // Task to run repeatedly every 2 seconds with an initial delay of second 3
        // This will execute repeatedly every 2 seconds + the time taken to execute the task 3 seconds = 5 seconds
        ScheduledExecutorService scheduledExecutorService2 = Executors.newScheduledThreadPool(3);
        scheduledExecutorService2.scheduleWithFixedDelay(() -> {
            System.out.println("ScheduledExecutorService2: Executed second: " + (System.currentTimeMillis() / 1000));
            try {
                TimeUnit.SECONDS.sleep(3); // Simulating a long-running task with 3 seconds will cause the task to be executed every 3 seconds
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 3, 2, TimeUnit.SECONDS); // Initial delay of 3 seconds and then executed every 2 seconds

        TimeUnit.SECONDS.sleep(10);
        scheduledExecutorService2.shutdown();
        scheduledExecutorService2.shutdownNow();
        System.out.println("scheduledExecutorService2 all tasks to complete");

        System.out.println("Main Thread Exited");

    }
}
