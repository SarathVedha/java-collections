package com.vedha.collections.thread;

public class RaceConditionIssue implements Runnable {

    // Shared resource
    private int balance = 100;

    @Override
    public void run() { // not synchronized method

        // Added control to maintain minimum balance 50
        if (balance >= 100) {
            System.out.println("Withdrawing money: " + Thread.currentThread().getName());

            balance -= 50;
        }else {
            System.out.println("Sorry, not enough balance for " + Thread.currentThread().getName());
        }
    }

    public int getBalance() {
        return balance;
    }

    public static void main(String[] args) throws InterruptedException {

        RaceConditionIssue raceConditionIssue = new RaceConditionIssue();

        Thread thread1 = new Thread(raceConditionIssue, "Vedha-1");
        Thread thread2 = new Thread(raceConditionIssue, "Vedha-2");

        // Both threads are trying to withdraw 50 from the same account at the same time
        thread1.start();
//        Thread.sleep(1000); // Added sleep to avoid concurrency issue and get the expected result
        thread2.start();

        thread1.join();thread2.join();

        // Expected 50 but got 0 because of concurrency issue, multiple threads are accessing the same object and updating the balance
        System.out.println("Final balance: " + raceConditionIssue.getBalance());
    }
}
