package com.vedha.collections.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter {

    // Shared resource
//    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        // AtomicInteger is thread-safe
        AtomicInteger counter = new AtomicInteger(0);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {

//                counter++;
//                synchronized (ThreadSafeCounter.class) {counter++;}
                counter.incrementAndGet();
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {

//                counter--;
//                synchronized (ThreadSafeCounter.class) {counter--;}
                counter.decrementAndGet();
            }
        }, "Thread-2");

        t1.start();t2.start();

        t1.join();t2.join();

//        System.out.println("Counter: " + counter);
        System.out.println("Counter: " + counter.get());
    }
}
