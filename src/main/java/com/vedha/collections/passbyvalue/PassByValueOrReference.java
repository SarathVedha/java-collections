package com.vedha.collections.passbyvalue;

public class PassByValueOrReference {

    // This method will not change the value of a because it is passed by value, not by reference.
    public static void passByValue(int a) {
        a = 10;
    }

    // This method will change the value of arr[0] because it is passed by reference.
    private static void passByReference(int[] arr) {
        arr[0] = 10;
    }

    // This method will change the value of user's name because it is passed by reference.
    private static void passByReference(User user) {
        user.setName("John");
        user = null;
    }

    // This method will change the value of user's name because it is passed by reference.
    private static User passByReferenceReturn(User user) {
        user.setName("John");
        user = null;

        return user;
    }

    public static void main(String[] args) {

//      Java is pass-by-value, always.
//      For primitive types: The actual value of the variable is passed to the method.
//      For objects: A copy of the reference to the object is passed,
//      This means you can modify the object itself within the method, but you cannot change the original reference to point to a different object.

        int a = 5;
        passByValue(a);
        System.out.println(a); // Output: 5

        // This method will change the value of a because it is passed by reference.
        int[] arr = {1, 2, 3};
        passByReference(arr);
        System.out.println(arr[0]); // Output: 10

        // This method will change the value of user's name because it is passed by reference.
        User user = new User("Alex");
        passByReference(user);
        System.out.println(user.getName()); // Output: John

        // This method will change the value of user's name because it is passed by reference.
//      For objects: A copy of the reference to the object is passed,
//      This means you can modify the object itself within the method, but you cannot change the original reference to point to a different object.
        User user1 = new User("Alex");
        User user3 = passByReferenceReturn(user1);
        System.out.println(user3); // Output: null
        System.out.println(user1.getName()); // Output: John

        User user2 = new User("Alex");
        user2 = passByReferenceReturn(user2);
        System.out.println(user2); // Output: null
    }
}

class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
