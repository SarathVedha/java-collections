package com.vedha.collections.designpattern;

import java.util.concurrent.TimeUnit;

/**
 * SingletonThreadSafeClass
 * A simple way to create a thread-safe singleton class is to make the global access method synchronized so that only one thread can execute this method at a time.
 * Here is a general implementation of this approach:
 */
public class SingletonThreadSafeClass {

    private static SingletonThreadSafeClass instance;

    // private constructor to avoid client applications using the constructor
    private SingletonThreadSafeClass(){}

    public synchronized static SingletonThreadSafeClass getInstance() throws InterruptedException {
        if(instance == null){
            TimeUnit.SECONDS.sleep(1);
            instance = new SingletonThreadSafeClass();
        }
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                SingletonThreadSafeClass instance1 = SingletonThreadSafeClass.getInstance();
                System.out.println(Thread.currentThread().getName() + " " + instance1.hashCode());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "instance1");

        Thread t2 = new Thread(() -> {
            try {
                SingletonThreadSafeClass instance2 = SingletonThreadSafeClass.getInstance();
                System.out.println(Thread.currentThread().getName() + " " + instance2.hashCode());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "instance2");

        t1.start();t2.start();

        t1.join();t2.join();

        SingletonThreadSafeClass instance1 = SingletonThreadSafeClass.getInstance();
        System.out.println(Thread.currentThread().getName() + " " + instance1.hashCode());

        SingletonThreadSafeClass instance2 = SingletonThreadSafeClass.getInstance();
        System.out.println(Thread.currentThread().getName() + " " + instance2.hashCode());

    }
}
