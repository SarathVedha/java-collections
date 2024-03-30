package com.vedha.collections.threading;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class ThreadingDemo {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");

        Runnable runnable = () -> {

            for (int i = 0; i < 3; i++) {
                strings.add("D");
                try {
                    TimeUnit.SECONDS.sleep(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println(strings);
        };

        Runnable runnable1 = () -> {

            for(String s : strings) {

                System.out.println("Thread Name: " + Thread.currentThread().getName());
                System.out.println("Thread Count: " + Thread.activeCount());
                System.out.println(s);
            }
        };


        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable1);

        t1.start();t2.start();
        t1.join();t2.join();

        System.out.println("Thread Name: " + Thread.currentThread().getName());
        System.out.println("Thread Count: " + Thread.activeCount());

        System.out.println("Main Thread");

    }
}
