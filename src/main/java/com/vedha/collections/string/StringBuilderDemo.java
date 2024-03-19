package com.vedha.collections.string;

/**
 * StringBuilderDemo
 * StringBuilder is mutable
 * StringBuilder is not thread safe
 * StringBuilder is faster than StringBuffer
 * StringBuilder is not synchronized
 * StringBuilder is introduced in Java 5
 * StringBuilder is used when we have to perform multiple modifications on the string
 * StringBuilder is not safe for use in multithreading environment
 */
public class StringBuilderDemo {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        System.out.println(sb.hashCode());
        sb.append("Hello");
        System.out.println(sb.hashCode());
        sb.append("World");
        System.out.println(sb.reverse());
        System.out.println(sb.hashCode());

    }
}
