package com.vedha.collections.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {

        // Using wait() and notifyAll()
        int size = 5; // size of shared queue
        Queue<Integer> sharedQ = new LinkedList<>(); // shared queue between producer and consumer

        Thread producer = new Thread(() -> {

            for (int i = 0; i < 10; i++) {

                synchronized (sharedQ) { // synchronized block to protect sharedQ object

                    // wait if the queue is full
                    while (sharedQ.size() == size) {
                        try {
                            System.out.println("1-Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + sharedQ.size());
                            sharedQ.wait(); // wait() will release the lock on sharedQ object and wait for another thread to notify
                        } catch (InterruptedException e) {
                            System.out.println("Interrupted Exception in Producer-1");
                        }
                    }

                    System.out.println("Producing-1 : " + (i + 1));
                    sharedQ.add((i + 1));

                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    sharedQ.notifyAll(); // notifyAll() will notify all threads waiting on sharedQ object for producer and consumer
                }

            }

        }, "Producer-1");

        Thread consumer = new Thread(() -> {

//            while (true) {
            for (int i = 0; i < 10; i++) {

                synchronized (sharedQ) { // synchronized block to protect sharedQ object

                    // wait if the queue is empty
                    while (sharedQ.isEmpty()) {
                        try {
                            System.out.println("1-Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + 0);
                            sharedQ.wait(); // wait() will release the lock on sharedQ object and wait for another thread to notify
                        } catch (InterruptedException e) {
                            System.out.println("Interrupted Exception in Consumer-1");
                        }
                    }

                    int number = sharedQ.remove();
                    System.out.println("Consuming-1 : " + number);

                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    sharedQ.notifyAll(); // notifyAll() will notify all threads waiting on sharedQ object for producer and consumer
                }

            }

        }, "Consumer-1");

        producer.start();consumer.start();

        producer.join();consumer.join();

        System.out.println("Producer and Consumer has finished");

        // Using BlockingQueue
        BlockingQueue<Integer> sharedQ1 = new LinkedBlockingQueue<>(5);

        Thread producer1 = new Thread(() -> {

            for (int i = 0; i < 10; i++) {

                try {
                    sharedQ1.put((i + 1));
                    System.out.println("Producing-2 : " + (i + 1));
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        }, "Producer-2");

        Thread consumer1 = new Thread(() -> {

            for (int i = 0; i < 10; i++) {

                try {
                    int number = sharedQ1.take();
                    System.out.println("Consuming-2 : " + number);
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        }, "Consumer-2");

        producer1.start();consumer1.start();

        producer1.join();consumer1.join();

        System.out.println("Producer and Consumer has finished");

    }
}
