package com.vedha.collections.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapConCurrent {

    public static void main(String[] args) throws InterruptedException {

//        HashMap is not thread-safe
//        If multiple threads are trying to access the same map object, it will throw ConcurrentModificationException
//        Map<String, Integer> map = new HashMap<>();

//         ConcurrentHashMap is thread-safe
        Map<String, Integer> map = new ConcurrentHashMap<>();

        Thread thread1 = new Thread(insert(map));
        Thread thread2 = new Thread(insert(map));
        Thread thread3 = new Thread(insert(map));
        Thread thread4 = new Thread(insert(map));
        Thread thread5 = new Thread(insert(map));

        thread1.start();thread2.start();thread3.start();thread4.start();thread5.start();


        thread1.join();thread2.join();thread3.join();thread4.join();thread5.join();

        System.out.println("Map size: " + map.size()); // Expected 500 but got less than 500 because of concurrency issue

        map.clear();
        map.put("Vedha", 100);
        map.put("Vedha2", 101);
        map.put("Vedha3", 102);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            map.put("Vedha4", 103); // ConcurrentModificationException
        }

        System.out.println("Map: " + map);
    }

    public static Runnable insert(Map<String, Integer> map) {

        return () -> {
            for (int i = 0; i < 100; i++) {
                map.put(Thread.currentThread().getName() + "-" + i, i);
            }
        };
    }
}
