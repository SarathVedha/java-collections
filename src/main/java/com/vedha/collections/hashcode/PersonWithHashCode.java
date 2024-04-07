package com.vedha.collections.hashcode;


import java.util.Objects;

public class PersonWithHashCode {

    private String name;
    private int age;

    public PersonWithHashCode(String name, int age) {
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
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "PersonWithHashCode{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

        PersonWithHashCode person1 = new PersonWithHashCode("John", 30);
        PersonWithHashCode person2 = new PersonWithHashCode("John", 30);

        System.out.println("Hash code of person1: " + person1.hashCode());
        System.out.println("Hash code of person2: " + person2.hashCode());

        System.out.println("Identity hash code of person1: " + System.identityHashCode(person1));
        System.out.println("Identity hash code of person2: " + System.identityHashCode(person2));

        System.out.println(person1 == person2); // false
        System.out.println("person1 == person2: " + (person1.hashCode() == person2.hashCode())); // true
        System.out.println("person1.equals(person2): " + person1.equals(person2)); // false
    }
}
