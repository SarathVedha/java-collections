package com.vedha.collections.designpattern;

// Enum Singleton is the best way to create a singleton class. It is thread-safe and also provides the serialization mechanism for free.
// The Enum class provides implicit support for thread safety and only one instance is guaranteed. The Enum class is loaded only once in the JVM.
public enum EnumSingleton {

    INSTANCE;

    public void doSomething(){

        System.out.println(Thread.currentThread().getName() + " - Enum Singleton doSomething() method called.");
    }
}

class EnumSingletonTest {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
            enumSingleton1.doSomething();
            System.out.println("Enum Singleton HashCode: " + enumSingleton1.hashCode());
        }, "instance1");

        Thread t2 = new Thread(() -> {
            EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
            enumSingleton2.doSomething();
            System.out.println("Enum Singleton HashCode: " + enumSingleton2.hashCode());
        }, "instance2");

        t1.start();t2.start();

        t1.join();t2.join();

        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
        enumSingleton1.doSomething();
        System.out.println("Enum Singleton HashCode: " + enumSingleton1.hashCode());

        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
        enumSingleton1.doSomething();
        System.out.println("Enum Singleton HashCode: " + enumSingleton2.hashCode());
    }
}
