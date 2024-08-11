package com.vedha.collections.boxing;

import java.util.stream.IntStream;

public class Boxing {

    public static void main(String[] args) {

        // Boxing and Unboxing
        int a = 10;
        Integer b = Integer.valueOf(a); // Manual Boxing
        int c = b.intValue(); // Manual Unboxing
        System.out.println("a: " + a + " b: " + b + " c: " + c);

        // Auto boxing and Unboxing done by compiler itself
        int d = 20;
        Integer e = d; // Auto boxing done by compiler internally uses Integer.valueOf(d)
        int f = e; // Auto Unboxing done by compiler internally uses e.intValue()
        System.out.println("d: " + d + " e: " + e + " f: " + f);

        // Boxing and Unboxing with null
        Integer g = null;
        int h = (g== null) ? 0 : g; // Unboxing null will throw NullPointerException
        System.out.println("g: " + g + " h: " + h);
        int i = g; // Unboxing null will throw NullPointerException
        System.out.println("g: " + g + " i: " + i);

    }
}
