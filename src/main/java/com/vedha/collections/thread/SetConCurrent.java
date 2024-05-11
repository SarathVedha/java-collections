package com.vedha.collections.thread;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

public class SetConCurrent {

    public static void main(String[] args) throws InterruptedException {

        // HashSet is not thread-safe if we try to modify the HashSet while iterating it, ConcurrentModificationException will be thrown
//        Set<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);

        // CopyOnWriteArraySet is a thread-safe variant of ArraySet in which all mutative operations
        // (add, set, and so on) are implemented by making a fresh copy of the underlying array.
        Set<Integer> set = new CopyOnWriteArraySet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 3; i++) {

                try {
                    set.add(i + 10);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("Thread Name: " + Thread.currentThread().getName() + " set: " + set);

        }, "Thread-1");

        Thread t2 = new Thread(() -> {

            for (Integer value : set) {

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " Value: " + value);
            }
        }, "Thread-2");

        // Start the threads
        t1.start();t2.start();

        t1.join();t2.join(); // wait for t1 and t2 to finish

        System.out.println("Final set: " + set);
    }
}
