package com.vedha.collections.thread;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class ListConCurrent {

    public static void main(String[] args) throws InterruptedException {

        // ArrayList is not thread-safe if we try to modify the ArrayList while iterating it, ConcurrentModificationException will be thrown
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);

        // CopyOnWriteArrayList is a thread-safe variant of ArrayList in which all mutative operations
        // (add, set, and so on) are implemented by making a fresh copy of the underlying array.
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 3; i++) {

                try {
                    list.add(i + 10);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("Thread Name: " + Thread.currentThread().getName() + " list: " + list);

        }, "Thread-1");

        Thread t2 = new Thread(() -> {

            for (Integer value : list) {

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

        System.out.println("Final list: " + list);
    }
}
