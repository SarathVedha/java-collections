package com.vedha.collections.equals;


public class PersonWithOutEquals {

    private String name;
    private int age;

    public PersonWithOutEquals(String name, int age) {
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
    public String toString() {
        return "PersonWithOutEquals{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

        PersonWithOutEquals person1 = new PersonWithOutEquals("John", 30);
        PersonWithOutEquals person2 = new PersonWithOutEquals("John", 30);

        // Basically equals method in object class compares with hashcode.
        // Equals method is used to compare the values of two objects need to override.
        System.out.println(person1.equals(person2)); // false

        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        // Compare the references of two objects with hashcode need to override.
        System.out.println(person1 == person2); // false
    }
}
