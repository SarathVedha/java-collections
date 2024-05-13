package com.vedha.collections.thread;

import java.util.concurrent.TimeUnit;

public class VolatileThread {

    // Shared resource
    static volatile int counter = 0;

    static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        }, "Thread-2");

        t1.start();t2.start();

        t1.join();t2.join();

        System.out.println("Counter: " + counter); // inconsistent output because volatile does not provide atomicity means read and write operation is atomic.

        // Volatile provides visibility but not atomicity.
        // Visibility means if one thread changes the value of the variable, then other threads can see the updated value.
        Thread t3 = new Thread(() -> {

            try {
                System.out.println("Waiting for 3 seconds..." + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
                flag = true;
                System.out.println("Flag set to true..." + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println("Thread-3 interrupted...");
            }
        }, "Thread-3");

        Thread t4 = new Thread(() -> {
            while(!flag) {
//                System.out.println("Waiting for flag to be true..." + Thread.currentThread().getName());
            }
            System.out.println("Flag is now true..." + Thread.currentThread().getName());
        }, "Thread-4");


        t3.start();t4.start();

        t3.join();t4.join();

        System.out.println("Main thread exiting...");

    }
}
