package com.vedha.collections.thread;

import java.util.concurrent.TimeUnit;

public class ThreadSynchronizedBlock {

    // Shared resource
    private double balance;

    public ThreadSynchronizedBlock(double balance) {
        this.balance = balance;
    }

    // Synchronized keyword is used to prevent multiple threads from accessing the same method at the same time.
    // Synchronized block is used to lock an object for any shared resource.
    // Synchronized block can be lock block of code only.
    public void deposit(double amount) {

        System.out.println("Thread Name: " + Thread.currentThread().getName() + " is depositing " + amount);

        try {
            TimeUnit.MILLISECONDS.sleep(700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (this) { // this is the object that is being locked. and thread safe.
            balance += amount;
        }
    }

    public void withdraw(double amount) {

        System.out.println("Thread Name: " + Thread.currentThread().getName() + " is withdrawing " + amount);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (this) { // this is the object that is being locked. and thread safe.
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadSynchronizedBlock account = new ThreadSynchronizedBlock(100);

        Thread deposit1 = new Thread(() -> {
            account.deposit(10);
        }, "Vedha-deposit-1");

        Thread deposit2 = new Thread(() -> {
            account.deposit(50);
        }, "Vedha-deposit-2");

        Thread withdraw1 = new Thread(() -> {
            account.withdraw(30);
        }, "Vedha-withdraw-2");

        Thread withdraw2 = new Thread(() -> {
            account.withdraw(20);
        }, "Vedha-withdraw-2");


        deposit1.start();
        deposit2.start();
        withdraw1.start();
        withdraw2.start();

        try {
            deposit1.join();
            deposit2.join();
            withdraw1.join();
            withdraw2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final Balance: " + account.getBalance()); // if not synchronized, the final balance will be incorrect sometimes.
    }
}
