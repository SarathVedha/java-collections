package com.vedha.collections.threadexecutor;

import java.util.concurrent.*;

public class MultipleProducerConsumer {

    // Multiple Producer and Consumer, Check in thread package for single producer and consumer
    public static void main(String[] args) {

        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i = 1; i <= 2; i++) {
            executorService.submit(new Producer(sharedQueue, i));
        }

        for (int i = 1; i <= 2; i++) {
            executorService.submit(new Consumer(sharedQueue, i));
        }

        executorService.shutdown();

    }
}

class Producer implements Runnable {

    private final BlockingQueue<Integer> queue;
    private final int producerId;

    public Producer(BlockingQueue<Integer> queue, int producerId) {
        this.queue = queue;
        this.producerId = producerId;
    }

    @Override
    public void run() {

        try{

            for(int i = 0; i < 5; i++) {

                int produce = (produce(producerId) + i);
                System.out.println("Producer-" + producerId + " produced " + produce);
                queue.put(produce);
                TimeUnit.SECONDS.sleep(2);
            }

        }catch (InterruptedException e) {
            System.out.println("Producer " + producerId + " interrupted");
        }
    }

    // Iteration 1: Producer-1 produced 100, 200, 300, 400, 500
    private int produce(int i) {
        return i * 100;
    }
}

class Consumer implements Runnable {

    private final BlockingQueue<Integer> queue;
    private final int consumerId;

    public Consumer(BlockingQueue<Integer> queue, int consumerId) {
        this.queue = queue;
        this.consumerId = consumerId;
    }

    @Override
    public void run() {

        try {

            while(!queue.isEmpty() || !Thread.currentThread().isInterrupted()){

                int consume = queue.take();
                System.out.println("Consumer-" + consumerId + " consumed " + consume);
                TimeUnit.SECONDS.sleep(2);
            }

        }catch (InterruptedException e) {
            System.out.println("Consumer " + consumerId + " interrupted");
        }
    }
}