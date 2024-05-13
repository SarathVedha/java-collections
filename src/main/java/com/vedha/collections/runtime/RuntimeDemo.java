package com.vedha.collections.runtime;

import java.io.IOException;
import java.math.BigInteger;

public class RuntimeDemo {

//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }

    @Override
    public int hashCode() {
        return 12345;
    }

    public static void main(String[] args) throws IOException {

        // Runtime class is used to interact with jvm
        Runtime runtime = Runtime.getRuntime();

        // availableProcessors() returns number of processors available to jvm
        int availableProcessors = runtime.availableProcessors();
        System.out.println("Available Processors: " + availableProcessors);

        // Jvm memory is not equal to physical memory
        // Jvm memory is limited by -Xmx and -Xms
        long maxMemory = runtime.maxMemory(); // maximum memory that jvm can use
        System.out.println("Max Memory: " + maxMemory);
        BigInteger divide = BigInteger.valueOf(maxMemory).divide(BigInteger.valueOf(1024 * 1024));
        System.out.println("Max Memory: " + (divide) + " MB");

        long freeMemory = runtime.freeMemory(); // free memory in jvm
        System.out.println("Free Memory: " + freeMemory);
        BigInteger divide2 = BigInteger.valueOf(freeMemory).divide(BigInteger.valueOf(1024 * 1024));
        System.out.println("Free Memory: " + (divide2) + " MB");

        long allocatedMemory = runtime.totalMemory(); // total memory allocated to jvm
        System.out.println("Allocated Memory: " + allocatedMemory);
        BigInteger divide3 = BigInteger.valueOf(allocatedMemory).divide(BigInteger.valueOf(1024 * 1024));
        System.out.println("Allocated Memory: " + (divide3) + " MB");

        BigInteger divide4 = BigInteger.valueOf((freeMemory + (maxMemory - allocatedMemory))).divide(BigInteger.valueOf(1024 * 1024));
        System.out.println("Total Free Memory: " + (divide4) + " MB"); // total free memory in jvm

        // gc() method is used to call garbage collector
        runtime.gc();
        System.out.println("Garbage Collector Called");

        // exec() method is used to execute commands in command prompt or terminal or to open applications in windows or linux
        Process notepad = runtime.exec("notepad");// opens notepad application
        System.out.println("Notepad Opened: " + notepad.isAlive());

        // exit() method is used to terminate jvm
        // 0 - normal termination
        // 1 - abnormal termination
        runtime.exit(0);

        System.out.println("JVM Terminated"); // this line will not be executed as jvm is terminated
    }
}
