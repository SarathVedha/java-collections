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

    public static SingletonLazyClass getInstance() {
        if (instance == null) {
            instance = new SingletonLazyClass();
        }
        return instance;
    }

    public static void main(String[] args) {

        SingletonLazyClass instance1 = SingletonLazyClass.getInstance();
        System.out.println(instance1.hashCode());

        SingletonLazyClass instance2 = SingletonLazyClass.getInstance();
        System.out.println(instance2.hashCode());

    }
}
