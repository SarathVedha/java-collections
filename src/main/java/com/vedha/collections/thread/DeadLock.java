package com.vedha.collections.thread;

import java.util.concurrent.TimeUnit;

public class DeadLock {

    // Deadlock occurs when two or more threads are waiting for each other to release the lock
    // In the below example, two threads are waiting for each other to release the lock
    // jps -l command to get the process id of the running java program
    // jstack <process id> command to get the thread dump of the running java program
    // jcmd <process id> Thread.print command to get the thread dump of the running java program
    public static void main(String[] args) throws InterruptedException {

        // Shared resources
        Object resource1 = new Object();
        Object resource2 = new Object();

        // Thread 1
        // Thread 1 locks resource1 and waits for resource2
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Locked resource1");
                try {
                    System.out.println("Thread 1 is sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Thread 1 is awake");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println("Thread 1: Locked resource2");
                }
            }
        }, "Vedha-1");

        // Thread 2
        // Thread 2 locks resource2 and waits for resource1
        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Locked resource2");
                try {
                    System.out.println("Thread 1 is sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Thread 1 is awake");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource1) {
                    System.out.println("Thread 2: Locked resource1");
                }
            }
        }, "Vedha-2");

        thread1.start();
        thread2.start();

        thread1.join();thread2.join();

        System.out.println("Deadlock occurred");
    }
}
