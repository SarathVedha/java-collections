package com.vedha.collections.thread;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ThreadingDemo {

    /* Thread States:
        New: The thread is created but not yet started.
        Runnable: The thread is ready to run, and the operating system is scheduling it to execute.
        Blocked/Waiting: The thread is waiting for a resource or another thread to release a lock.
        Timed Waiting: The thread is in a waiting state for a specified period.
        Terminated: The thread has finished its execution.
    */

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ArrayList<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");

        // Runnable is a functional interface,
        // Runnable is a functional interface that takes no arguments and returns no data.
        Runnable runnable = () -> {

            for (int i = 0; i < 3; i++) {
                synchronized (strings) {
                    strings.add("D");
                }

                try {
                    TimeUnit.SECONDS.sleep(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

            System.out.println(strings);
        };

        Runnable runnable1 = () -> {

            Thread.yield(); // give up the CPU to other threads with the same priority

            synchronized (strings){

                for(String s : strings) {

                    System.out.println("Thread Name: " + Thread.currentThread().getName());
                    System.out.println("Thread Count: " + Thread.activeCount());
                    System.out.println(s);
                }
            }

        };


        Thread t1 = new Thread(runnable);
        t1.setPriority(Thread.MIN_PRIORITY); // Thread.MIN_PRIORITY = 1, Thread.MAX_PRIORITY = 10

        Thread t2 = new Thread(runnable1);

        // Start the threads
        t1.start();t2.start(); // t1.run();t2.run();
//        t1.interrupt(); // interrupt the thread t1 means interrupt the sleep method in the runnable

        t1.join();t2.join(); // wait for t1 and t2 to finish

        System.out.println("Thread Name: " + Thread.currentThread().getName());
        System.out.println("Thread Count: " + Thread.activeCount());

        System.out.println("Main Thread");

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "Hello").thenApplyAsync(s -> s + " World");

        System.out.println("Async: " + stringCompletableFuture.get());

        // Lambda Runnable
        Thread thread = new Thread(() -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            System.out.println("Thread Count: " + Thread.activeCount());
        });
        thread.start();
        thread.join();

        System.out.println("-----------------------");

        // user(normal) thread vs daemon thread
        // User Thread is a thread created by the user.It is a high priority thread that runs in the foreground.
        Thread userThread = new Thread(() -> {
            try {

                for (int i = 0; i < 10; i++) {

                    System.out.println("User Thread: " + i);
                    TimeUnit.SECONDS.sleep(1);
                }
            }catch (Exception e) {
                System.err.println(e);
            }

        });

        // Daemon Thread is a low priority thread that runs in the background to perform tasks such as garbage collection.
        // Daemon threads are terminated by the JVM when there are no user(normal) threads running.
        Thread daemonThread = new Thread(() -> {
            try {

                for (int i = 0; i < 10; i++) {

                    System.out.println("Daemon Thread: " + i);
                    TimeUnit.SECONDS.sleep(2);
                }
            }catch (Exception e) {
                System.err.println(e);
            }

        });

        userThread.start(); // with 1 sec sleep
        daemonThread.setDaemon(true); // with 2 sec sleep
        daemonThread.start(); // daemon thread will be terminated when user thread is finished
    }
}
