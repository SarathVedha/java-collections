package com.vedha.collections.thread;

// Read - Write - modify race condition example
// Race condition occurs when two or more threads try to update the shared variable concurrently
// In the below example, two threads are trying to update the shared variable concurrently
// The output is unpredictable because the shared variable is not updated atomically,
// atomically means the shared variable should be updated in a single step without any interruption from other threads
// To fix this 1. Use synchronized block 2. Use AtomicInteger 3. Use Lock
public class RaceIssue implements Runnable {

    // Shared variable
    private int shared = 0;

    // Increment the shared variable 10000 times in a loop with multiple threads
    @Override
    public void run() { // not synchronized method

        for (int i = 0; i < 10000; i++) {
//            synchronized (this) {shared++;}
            shared++;
        }
    }

    public int getCounter() {
        return shared;
    }

    public static void main(String[] args) throws InterruptedException {

        RaceIssue raceIssue = new RaceIssue();

        // Two threads are trying to update the shared variable concurrently
        Thread thread1 = new Thread(raceIssue);
        Thread thread2 = new Thread(raceIssue);

        thread1.start();thread2.start();

        thread1.join();thread2.join();

        // Unpredictable output because of not using synchronized block
        System.out.println("Counter: " + raceIssue.getCounter()); // Expected 20000 but actual value is less than 20000(eg: 15559, 19876, etc.)
    }
}

