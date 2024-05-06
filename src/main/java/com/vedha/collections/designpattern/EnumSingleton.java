package com.vedha.collections.designpattern;

// Enum Singleton is the best way to create a singleton class. It is thread-safe and also provides the serialization mechanism for free.
// The Enum class provides implicit support for thread safety and only one instance is guaranteed. The Enum class is loaded only once in the JVM.
public enum EnumSingleton {

    INSTANCE;

    public void doSomething(){

        System.out.println("Enum Singleton doSomething() method called.");
    }
}

class EnumSingletonTest {

    public static void main(String[] args) {

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        enumSingleton.doSomething();
    }
}
