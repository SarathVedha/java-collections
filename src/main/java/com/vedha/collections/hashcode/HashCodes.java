package com.vedha.collections.hashcode;

public class HashCodes {

    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "abc";

        // Hash code method available in String class
        System.out.println("Hash code of str1: " + str1.hashCode());
        System.out.println("Hash code of str2: " + str2.hashCode());

        // Identity hash code native method available in Object class
        System.out.println("Hash code of str1: " + System.identityHashCode(str1));
        System.out.println("Hash code of str2: " + System.identityHashCode(str2));

        // Hash code of two different objects
        String str3 = new String("abc"); // new object created
        System.out.println("Hash code of str3: " + str3.hashCode()); // Overridden hashCode method in String class
        System.out.println("Hash code of str3: " + System.identityHashCode(str3)); // Identity hash code native method in Object class

        Integer integer = 2000;
        Integer integer1 = 2000;

        // Hash code method available in Integer class
        System.out.println("Hash code of integer: " + integer.hashCode());
        System.out.println("Hash code of integer1: " + integer1.hashCode());

        // Identity hash code native method available in Object class
        System.out.println("Hash code of integer: " + System.identityHashCode(integer));
        System.out.println("Hash code of integer1: " + System.identityHashCode(integer1));

    }
}
