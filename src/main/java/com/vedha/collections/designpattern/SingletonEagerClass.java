package com.vedha.collections.designpattern;

/**
 * 1. Eager initialization
 * In eager initialization, the instance of the singleton class is created at the time of class loading.
 * The drawback to eager initialization is that the method is created even though the client application might not be using it.
 * Here is the implementation of the static initialization singleton class:
 */
public class SingletonEagerClass {

    // Single instance created
    private static final SingletonEagerClass instance = new SingletonEagerClass();

    // private constructor to avoid client applications using the constructor
    private SingletonEagerClass() {}

    public static SingletonEagerClass getInstance() {

        return instance;
    }

    public static void main(String[] args) {

        SingletonEagerClass instance1 = SingletonEagerClass.getInstance();
        SingletonEagerClass instance2 = SingletonEagerClass.getInstance();

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }

}
