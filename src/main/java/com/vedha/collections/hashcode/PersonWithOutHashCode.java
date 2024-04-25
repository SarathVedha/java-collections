package com.vedha.collections.hashcode;

public class PersonWithOutHashCode {

    private String name;
    private int age;

    public PersonWithOutHashCode(String name, int age) {
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
        return "PersonWithOutHashCode{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

        PersonWithOutHashCode person1 = new PersonWithOutHashCode("John", 30);
        PersonWithOutHashCode person2 = new PersonWithOutHashCode("John", 30);
        PersonWithOutHashCode person3 = new PersonWithOutHashCode("John", 30);


        System.out.println("Hash code of person1: " + person1.hashCode());
        System.out.println("Hash code of person2: " + person2.hashCode());
        System.out.println("Hash code of person3: " + person3.hashCode());
        person3.setName("Vedha");
        System.out.println("Hash code of person3: " + person3.hashCode());

        System.out.println("Identity hash code of person1: " + System.identityHashCode(person1));
        System.out.println("Identity hash code of person2: " + System.identityHashCode(person2));
        System.out.println("Identity hash code of person3: " + System.identityHashCode(person3));

        System.out.println(person1 == person2); // false
        System.out.println("person1 == person2: " + (person1.hashCode() == person2.hashCode())); // false
        System.out.println("person1.equals(person2): " + person1.equals(person2)); // false
    }
}
