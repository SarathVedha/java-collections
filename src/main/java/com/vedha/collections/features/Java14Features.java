package com.vedha.collections.features;

/**
 * Records are a new feature in Java 14.
 * A record is a new kind of type declaration in Java.
 * It is a restricted form of a class. It is a simple way of writing a class that is a simple data carrier.
 * It is a final class that has final fields.
 * It is a transparent carrier for immutable data.
 */
public class Java14Features {

    public record Person(String name, String location) { }

    public static void main(String[] args) {

        Person p = new Person("Vedha", "Chennai");
        System.out.println(p.name());
        System.out.println(p.location());
        System.out.println(p);
        System.out.println(p.hashCode());

        Person p2 = new Person("Vedha", "Chennai");
        System.out.println(p2.hashCode());
        System.out.println(p.equals(p2));

        RecordDemo recordDemo = new RecordDemo("Vedha", 23, "Chennai", "India");
        System.out.println(recordDemo.name());
        System.out.println(recordDemo);
        System.out.println(recordDemo.hashCode());

    }

}
