package com.vedha.collections.comparableComparator;

import java.util.*;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

public class ComparableComparatorDemo {

    public static void main(String[] args) {

        // Primitive array having a pre-defined sorting mechanism in arrays class
        int[] arr = {2, 3, 10, 4, 1};
        System.out.println("arr unsorted = " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("arr sorted = " + Arrays.toString(arr));

        // but an Integer array doesn't have a pre-defined sorting mechanism in arrays class its object.
        Integer[] arr1 = {2, 3, 10, 4, 1}; // So we have to implement the Comparable interface, but Integer class already implemented the Comparable interface.
        Arrays.sort(arr1);
        System.out.println("arr1 sorted = " + Arrays.toString(arr1));

        // Custom object array doesn't have a pre-defined sorting mechanism in arrays class.
        // So we have to implement the Comparable interface or pass the Comparator object.
        Random from = Random.from(RandomGenerator.getDefault());
        User[] users = {
                new User(from.nextInt(1, 100), from.nextInt(18, 80), "Master"),
                new User(from.nextInt(1, 100), from.nextInt(18, 80), "Vedha"),
                new User(from.nextInt(1, 100), from.nextInt(18, 80), "Ravi"),
                new User(from.nextInt(1, 100), from.nextInt(18, 80), "Ravi Kumar"),
                new User(from.nextInt(1, 100), from.nextInt(18, 80), "ravi Kumar"),
                new User(from.nextInt(1, 100), from.nextInt(18, 80), "Rabin")
        };

        System.out.println("users unsorted = " + Arrays.toString(users));

        Arrays.sort(users); // This will throw a compilation error because User class doesn't implement the Comparable interface.
        System.out.println("users sorted = " + Arrays.toString(users));

        // Lambda expression
        Arrays.sort(users, (o1, o2) -> o1.getId().compareTo(o2.getId())); // This will sort the users based on the id.

        // Anonymous inner class
        Comparator<User> comparator = new Comparator<>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
        Arrays.sort(users, comparator); // This will sort the users based on the id.

        Arrays.sort(users, User.ageComparator); // This will sort the users based on the age.

        // Method reference
        Arrays.sort(users, Comparator.comparing(User::getId)); // Method reference natural sorting order, ascending order
        Arrays.sort(users, Comparator.comparing(User::getId, Comparator.reverseOrder())); // This will sort the users based on the id in descending order.

        Arrays.sort(users, Comparator.comparing(User::getAge, Comparator.reverseOrder())); // This will sort the users based on the age in descending order.
        System.out.println("users sorted id = " + Arrays.toString(users));

        Arrays.sort(users, Comparator.comparing(User::getName)); // This will sort the users based on the name.
        System.out.println("users sorted name = " + Arrays.toString(users));

        Arrays.sort(users, Comparator.comparing(User::getName, String::compareToIgnoreCase)); // This will sort the users based on the name.
        System.out.println("users sorted name = " + Arrays.toString(users));

        Arrays.sort(users, Comparator.comparing(User::getName, String::compareToIgnoreCase).reversed()); // This will sort the users based on the name in descending order.
        System.out.println("users sorted name = " + Arrays.toString(users));

        // Using Collections class
        List<Integer> integers = Random.from(RandomGenerator.getDefault())
                .ints(1, 30)
                .limit(20).boxed().collect(Collectors.toList());

        integers.toArray(new Integer[0]);
        System.out.println("integers = " + integers);

        Collections.sort(integers); // This will sort the integers in ascending order. Internally it uses the Arrays.sort method.
        System.out.println("integers sorted = " + integers);

        // Natural sorting order, ascending order
        integers.sort(Comparator.naturalOrder()); // This will sort the integers in ascending order.
        System.out.println("integers sorted = " + integers);

        integers.sort(Comparator.reverseOrder()); // This will sort the integers in descending order.
        System.out.println("integers sorted = " + integers);

        // Custom object list doesn't have a pre-defined sorting mechanism in collections class.
        // So we have to implement the Comparable interface or pass the Comparator object.
        List<User> userList = Arrays.asList(users);
        System.out.println("userList unsorted = " + userList);

        Collections.sort(userList); // This will throw a compilation error because User class doesn't implement the Comparable interface.
        System.out.println("userList sorted = " + userList);

        userList.sort(Comparator.comparing(User::getId)); // This will sort the userList based on the id.
        System.out.println("userList sorted id = " + userList);

        userList.sort(User.ageComparator); // This will sort the userList based on the age.
        System.out.println("userList sorted age = " + userList);

        userList.sort(Comparator.comparing(User::getName)); // This will sort the userList based on the name.
        System.out.println("userList sorted name = " + userList);

        userList.sort(Comparator.comparing(User::getName, String::compareToIgnoreCase)); // This will sort the userList based on the name.
        System.out.println("userList sorted name = " + userList);

        userList.sort(Comparator.comparing(User::getName, String::compareToIgnoreCase).reversed()); // This will sort the userList based on the name in descending order.
        System.out.println("userList sorted name = " + userList);

    }
}

class User implements Comparable<User> {

    // Implement the Comparator interface. This is used to sort the object based on the age.
    public static Comparator<User> ageComparator = (o1, o2) -> Integer.compare(o1.getAge(), o2.getAge());
    // Implement the Comparator interface. This is used to sort the object based on the name.
    public static Comparator<User> nameComparator = (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName());
    private Integer id;
    private int age;
    private String name;

    public User(Integer id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return age == user.age && Objects.equals(id, user.id) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    // Implement the compareTo method of the Comparable interface.
    // This method is used to sort the object based on the id. If you want to sort based on the name, then you can change the logic.
    @Override
    public int compareTo(User o) {

        // Sort by id
        return this.id.compareTo(o.id); // Natural sorting order, ascending order

        // Sort by age
        // return (x < y) ? -1 : ((x == y) ? 0 : 1);
        // return Integer.compare(this.age, o.age);

        // Sort by name
        // return this.name.compareTo(o.name);
    }
}
