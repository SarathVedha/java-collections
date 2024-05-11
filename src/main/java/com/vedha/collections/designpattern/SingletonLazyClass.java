package com.vedha.collections.designpattern;

/**
 * SingletonLazyClass
 * Lazy initialization method to implement the singleton pattern creates the instance in the global access method.
 * Here is the sample code for creating the singleton class with this approach:
 */
public class SingletonLazyClass {

    private static SingletonLazyClass instance;

    // private constructor to avoid client applications using the constructor
    private SingletonLazyClass(){}

    public static SingletonLazyClass getInstance() throws InterruptedException {
        if (instance == null) {
            Thread.sleep(1000);
            instance = new SingletonLazyClass();
        }
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                SingletonLazyClass instance1 = SingletonLazyClass.getInstance();
                System.out.println(Thread.currentThread().getName() + " " + instance1.hashCode());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "instance1");

        Thread t2 = new Thread(() -> {
            try {
                SingletonLazyClass instance2 = SingletonLazyClass.getInstance();
                System.out.println(Thread.currentThread().getName() + " " + instance2.hashCode());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "instance2");

        t1.start();t2.start();

        t1.join();t2.join();

        SingletonLazyClass instance1 = SingletonLazyClass.getInstance();
        System.out.println(Thread.currentThread().getName() + " " + instance1.hashCode());

        SingletonLazyClass instance2 = SingletonLazyClass.getInstance();
        System.out.println(Thread.currentThread().getName() + " " + instance2.hashCode());

    }
}
