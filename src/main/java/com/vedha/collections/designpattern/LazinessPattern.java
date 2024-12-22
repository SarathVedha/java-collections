package com.vedha.design;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class LazinessPattern {

    public static int compute(int number) {

        System.out.println("Slow Process!!");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Math.multiplyExact(number, 10);
    }

    public static void operate(int computeValue) {

        if (Math.random() > 0.5) {

            System.out.println("Using Compute Value: " + computeValue);
        } else {

            System.out.println("Skipping Compute Value!!");
        }
    }

    // Using lambda to skipping the computation and archiving the laziness
    public static void operate2(Supplier<Integer> computeValue) {

        if (Math.random() > 0.5) {

            System.out.println("Using Compute Value: " + computeValue.get());
        } else {

            System.out.println("Skipping Compute Value!!");
        }
    }

    public static void main(String[] args) {

        // Some time the compute value will not be used but compute will always call.
        operate(compute(100));

        // using lambda to skipping compute process
        operate2(() -> compute(100));

    }
}
