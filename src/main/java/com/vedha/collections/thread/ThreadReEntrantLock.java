package com.vedha.collections.thread;

import lombok.Getter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadReEntrantLock {

    // Reentrant lock
    private final ReentrantLock reentrantLock = new ReentrantLock(true);
    // Shared resource
    @Getter
    private Double balance;

    public ThreadReEntrantLock(Double balance) {
        this.balance = balance;
    }

    public void deposit(Double amount) {

        reentrantLock.lock(); // lock() method is used to acquire the lock
        System.out.println("Lock is acquired: " + Thread.currentThread().getName());
        try {

            TimeUnit.MILLISECONDS.sleep(500);
            balance += amount;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock(); // unlock() method is used to release the lock
        }

    }

    public void withDraw(Double amount) {

        reentrantLock.lock(); // lock() method is used to acquire the lock
        System.out.println("Lock is acquired: " + Thread.currentThread().getName());
        try {

            TimeUnit.SECONDS.sleep(1);
            balance -= amount;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock(); // unlock() method is used to release the lock
        }

    }

    public static void main(String[] args) throws InterruptedException {

        ThreadReEntrantLock threadReEntrantLock = new ThreadReEntrantLock(1000.0);

        Thread deposit1 = new Thread(() -> threadReEntrantLock.deposit(100.0), "Deposit-1");
        Thread deposit2 = new Thread(() -> threadReEntrantLock.deposit(200.0), "Deposit-2");

        Thread withDraw1 = new Thread(() -> threadReEntrantLock.withDraw(50.0), "WithDraw-1");
        Thread withDraw2 = new Thread(() -> threadReEntrantLock.withDraw(20.0), "WithDraw-2");

        deposit1.start();
        deposit2.start();
        withDraw1.start();
        withDraw2.start();

        deposit1.join();
        deposit2.join();
        withDraw1.join();
        withDraw2.join();

        System.out.println("Final balance: " + threadReEntrantLock.getBalance());
    }

}
