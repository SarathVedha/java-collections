package com.vedha.collections.equals;

public class Equals {

    public static void main(String[] args) {

        // primitive data types(8) are compared using == operator.
        // == operator is used to compare the references of two objects with hashcode need to override.
        int a = 10;
        int b = 10;
        System.out.println("int primitive data: " + (a == b)); // true

        double c = 10.0;
        double d = 10.0;
        System.out.println("double primitive data: " + (c == d)); // true


        // equals() method is used to compare the values of two objects.
        // == operator is used to compare the references of two objects with hashcode need to override.

        // Objects are compared using equals() method.
        // equals() method is used to compare the values of two objects.
        // Objects are stored in the heap memory.
        String s1 = new String("Hello"); // new is new memory allocation
        String s2 = new String("Hello");

        System.out.println(s1.equals(s2)); // true
        System.out.println(s1 == s2); // false

        String map = s2; // mapping s3 with s2 object reference
        System.out.println(map.equals(s2)); // true
        System.out.println(map == s2); // true

        // Using String literals to create objects.
        // String literals are stored in the String pool.
        // String pool is a memory area in the heap memory.
        String s3 = "Hello"; // Using same object reference
        String s4 = "Hello";

        System.out.println(s3.equals(s4)); // true
        System.out.println(s3 == s4); // true

        String s5 = "Hello";
        String s6 = new String("Hello");

        System.out.println(s5.equals(s6)); // true
        System.out.println(s5 == s6); // false

        //
        Integer integer = 10; // stored in Integer cache from -128 to 127
        Integer integer1 = Integer.valueOf(10); // stored in Integer cache from -128 to 127

        System.out.println(integer.equals(integer1)); // true
        System.out.println(integer == integer1); // true

        integer = Integer.valueOf(1000); // diff object not in cache
        integer1 = Integer.valueOf(1000); // diff object not in cache
        System.out.println(integer.equals(integer1)); // true
        System.out.println(integer == integer1); // false

    }
}
