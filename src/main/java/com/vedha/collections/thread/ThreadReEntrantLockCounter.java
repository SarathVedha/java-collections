package com.vedha.collections.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadReEntrantLockCounter implements Runnable {

    // Shared variable
    private static int size = 0;

    // ReentrantLock is a lock that allows the same thread to acquire the lock multiple times
    // ReentrantLock is an alternative to synchronized block
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        try {
            lock.lock();
            for (int i = 0; i < 20000; i++) {

                size++;
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadReEntrantLockCounter threadReEntrantLockCounter = new ThreadReEntrantLockCounter();

        Thread thread1 = new Thread(threadReEntrantLockCounter, "Thread-1");
        Thread thread2 = new Thread(threadReEntrantLockCounter, "Thread-2");

        thread1.start();thread2.start();

        thread1.join();thread2.join();

        System.out.println("Counter: " + size); // Expected 20000
    }
}
