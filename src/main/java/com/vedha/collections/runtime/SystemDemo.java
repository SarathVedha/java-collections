package com.vedha.collections.runtime;

import java.util.Map;
import java.util.Properties;

public class SystemDemo {

    public static void main(String[] args) {

        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("Current time in milliseconds: " + currentTimeMillis);

        long nanoTime = System.nanoTime();
        System.out.println("Current time in nanoseconds: " + nanoTime);

        // System properties are a set of key-value pairs that are defined by the Java Virtual Machine (JVM).
        // They contain information about the system configuration, such as the current user,
        // the current version of the JVM, and the file path-name separator.
        Properties properties = System.getProperties(); // Get the value of the specified system property and jvm properties
        properties.list(System.out); // Prints all system properties
        System.out.println("--End of Properties--");

        System.setProperty("myKey", "myValue"); // Set the system property indicated by the specified key.
        System.out.println("myKey: " + System.getProperty("myKey")); // Get the value of the specified system property

        Properties properties2 = System.getProperties(); // Get the value of the specified system property and jvm properties
        properties2.list(System.out); // set properties added
        System.out.println("--End of Properties--");

        // Environment variables, on the other hand, are a set of key-value pairs that are defined by the operating system.
        // They contain information about the system environment,
        // such as the user's home directory and the path to the system executable files.
        Map<String, String> map = System.getenv(); // Get the value of the specified operating system environment variable
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println("--End of Environment Variables--");

        // Here is a table that summarizes the key differences between the two methods:
        // Feature       System.getProperty()                   System.getenv()
        // Scope          System properties                 Environment variables
        // Settable             Yes                                 No // System properties can be set programmatically, while environment variables cannot.
        // Values      JVM configuration information       System environment information
        // Usage       JVM configuration, system info       System configuration, user info
        // Access      System.getProperty("key")            System.getenv("key")


        String lineSeparator = System.lineSeparator();// Returns the system-dependent line separator string.
        System.out.println("Line Separator: " + lineSeparator);

        RuntimeDemo runtimeDemo = new RuntimeDemo();
        int hashCode = runtimeDemo.hashCode();// Returns a hash code value for the object.
        System.out.println("Hash Code: " + hashCode);

        // Returns the same hash code for the given object as would be returned by the default method hashCode(),
        // whether or not the given object's class overrides hashCode().
        int identityHashCode = System.identityHashCode(runtimeDemo);
        System.out.println("Identity Hash Code: " + identityHashCode);

        // gc() method is used to call garbage collector
        // The garbage collector is a program that runs on the Java Virtual Machine (JVM) to reclaim memory that is no longer being used by the program.
        // Internally, System.gc() calls Runtime.getRuntime().gc().
        System.gc();

        // exit() method is used to terminate jvm
        // 0 - normal termination
        // 1 - abnormal termination
        // Internally, System.exit() calls Runtime.getRuntime().exit().
        System.exit(0); // Terminates the currently running Java Virtual Machine.

        System.out.println("This will not be printed");
    }
}
