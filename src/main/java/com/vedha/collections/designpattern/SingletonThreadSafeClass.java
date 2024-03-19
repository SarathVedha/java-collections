package com.vedha.collections.designpattern;

/**
 * SingletonThreadSafeClass
 * A simple way to create a thread-safe singleton class is to make the global access method synchronized so that only one thread can execute this method at a time.
 * Here is a general implementation of this approach:
 */
public class SingletonThreadSafeClass {

    private static SingletonThreadSafeClass instance;

    private SingletonThreadSafeClass(){}

    public static synchronized SingletonThreadSafeClass getInstance(){
        if(instance == null){
            instance = new SingletonThreadSafeClass();
        }
        return instance;
    }

    public static void main(String[] args) {

        SingletonThreadSafeClass instance1 = SingletonThreadSafeClass.getInstance();
        System.out.println(instance1.hashCode());
        SingletonThreadSafeClass instance2 = SingletonThreadSafeClass.getInstance();
        System.out.println(instance2.hashCode());
    }
}
