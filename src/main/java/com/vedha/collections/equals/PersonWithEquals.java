package com.vedha.collections.equals;

import java.util.Objects;

public class PersonWithEquals {

    private String name;
    private int age;

    public PersonWithEquals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonWithEquals that)) return false;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return "PersonWithEquals{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

        PersonWithEquals person1 = new PersonWithEquals("John", 30);
        PersonWithEquals person2 = new PersonWithEquals("John", 30);

        // Equals method is used to compare the values of two objects need to override.
        System.out.println(person1.equals(person2)); // true

        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        // Compare the references of two objects with hashcode need to override.
        System.out.println(person1 == person2); // false

    }
}
