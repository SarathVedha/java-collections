package com.vedha.collections.string;

/**
 * StringBufferDemo
 * StringBuffer is mutable and synchronized
 * StringBuffer is thread safe
 * StringBuffer is slow
 * StringBuffer is used when multiple threads are working on the same object
 * StringBuffer is used when the string is large and performance is not a concern
 */
public class StringBufferDemo {

    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(stringBuffer.length());
        System.out.println(stringBuffer.capacity());
        System.out.println(stringBuffer.hashCode());
        System.out.println(stringBuffer.append("Hello"));
        System.out.println(stringBuffer.hashCode());
        System.out.println(stringBuffer.append("World"));
        System.out.println(stringBuffer.hashCode());
        System.out.println(stringBuffer.reverse());
    }
}
