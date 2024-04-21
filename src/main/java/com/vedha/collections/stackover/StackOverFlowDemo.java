package com.vedha.collections.stackover;

public class StackOverFlowDemo {

    static int count = 0;
    public static void recursiveMethod() {

        count++;
        if (count % 1000 == 0) {
            System.out.println("Recursive method call: " + count);
        }
        recursiveMethod();
    }

    public static void main(String[] args) {

        // This will cause StackOverflowError
        // Thread will go out of stack memory and throw StackOverflowError
        // Each Thread has its own stack memory and if it is full then it will throw StackOverflowError
        // VM Args -Xss512k (Stack size is 512KB) -Xss1m (Stack size is 1MB) -Xss1m is default stack size
        // -Xss512k will run 7000+ recursive calls and throw StackOverflowError
        // -Xss1m will run 15000+ recursive calls and throw StackOverflowError
        recursiveMethod(); // Recursive method calling itself
    }
}
