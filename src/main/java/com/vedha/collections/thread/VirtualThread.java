package com.vedha.collections.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class VirtualThread {

    public static void main(String[] args) throws InterruptedException {

        // Virtual Thread is introduced in Java 21
        // VirtualThread is a lightweight thread that is managed by the JVM; Normal Thread is handled by the OS
        // It is not associated with any OS thread
        // VirtualThread is created using Thread.startVirtualThread() method

        Thread virtualThread = Thread.startVirtualThread(() -> {

            //Virtual threads do not have a thread name by default. The getName method returns the empty string if a thread name is not set.
            System.out.println("Running task in a virtual thread: "
                    + Thread.currentThread().getName());

            System.out.println("Thread Id: " + Thread.currentThread().threadId());
            System.out.println("Thread Group: " + Thread.currentThread().getThreadGroup());
            System.out.println("is Virtual: " + Thread.currentThread().isVirtual());

        });

        // Waiting for virtual threads to complete
        virtualThread.join();

        Thread virtualThread1 = Thread.ofVirtual().name("Virtual-Thread-", 0).start(() -> {
            System.out.println("Running task in a virtual thread: "
                    + Thread.currentThread().getName());

            System.out.println("Thread Id: " + Thread.currentThread().threadId());
            System.out.println("Thread Group: " + Thread.currentThread().getThreadGroup());
            System.out.println("is Virtual: " + Thread.currentThread().isVirtual());

        });

        virtualThread1.join();

        System.out.println("Main thread completed");
    }
}
