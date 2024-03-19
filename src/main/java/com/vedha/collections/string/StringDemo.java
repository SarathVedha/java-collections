package com.vedha.collections.string;

/**
 * StringDemo
 * String is immutable
 */
public class StringDemo {

    public static void main(String[] args) {

        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        String s4 = new String("Hello");

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s3 == s4); // false

        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // true
        System.out.println(s3.equals(s4)); // true

        s1 = s1 + s2;
        System.out.println(s1);
        System.out.println(s1.hashCode());

        String addedNames = "Added ";
        String[] arr = {"Vedha", "vedha2", "vedha3"};
        for (String s : arr) {

            addedNames += s;
            System.out.println(addedNames.hashCode()); // creating multiple objects
        }
        System.out.println(addedNames);
    }
}
