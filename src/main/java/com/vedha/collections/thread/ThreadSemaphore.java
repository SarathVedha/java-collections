package com.vedha.collections.thread;

import java.util.concurrent.Semaphore;

public class ThreadSemaphore implements Runnable {

    // Shared resource
    private static int counter;

    // Semaphore with 2 permits to allow 2 threads to access the shared resource at a time
    private final Semaphore semaphore;

    public ThreadSemaphore(int permitsCount) {

        this.semaphore = new Semaphore(permitsCount);
    }

    @Override
    public void run() {

        try {
            semaphore.acquire();
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // Creating a semaphore with 2 permits
        ThreadSemaphore threadSemaphore = new ThreadSemaphore(1);

        // Creating 2 threads
        Thread thread1 = new Thread(threadSemaphore);
        Thread thread2 = new Thread(threadSemaphore);

        thread1.start();thread2.start();

        thread1.join();thread2.join();

        // Getting invalid value because semaphore has 2 permits
        // and 2 threads are accessing the shared resource at a time
        // if permits are 1 then the output will be 20000 because only 1 thread can access the shared resource at a time
        System.out.println("Counter: " + counter);

    }
}
