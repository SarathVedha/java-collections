package com.vedha.design;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.IntStream;

public class MultiThread {

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {

            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName().concat(": Iam Done!!"));
            } catch (Exception ignored) {
            }

        };

//        runInLoop(task);
//        runInStream(task);
//        runInParallelStream(task);

        System.out.println(Long.MAX_VALUE); // 2 power 63 - 1
        System.out.println(power(63).subtract(BigInteger.ONE));

        System.out.println(Float.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);

        System.out.println(IntStream.range(0, 1).limit(5000).count());
    }

    public static BigInteger power(int times) {

        BigInteger one = BigInteger.TWO;
        for (int i = 1; i < times; i++) {

            one = one.multiply(BigInteger.valueOf(2));
        }

        return one;
    }

    static void runInLoop(Runnable task) throws InterruptedException {
        Instant start = Instant.now();
        List<Thread> listThread = IntStream.range(0, 5)
//                .mapToObj(value -> Thread.ofVirtual().unstarted(task))
                .mapToObj(value -> new Thread(task))
                .toList();

        for (Thread thread : listThread) {

            thread.start();
        }

        for (Thread thread : listThread) {

            thread.join();
        }

        Instant end = Instant.now();
        System.out.println("Elapsed Time: " + Duration.between(start, end).toMillis() + ".ms");
    }

    static void runInStream(Runnable task) {
        Instant start = Instant.now();
        IntStream.range(0, 5)
//                .mapToObj(value -> Thread.ofVirtual().start(task)) // virtual thread start will return thread object
                .mapToObj(value -> new Thread(task))
                .forEach(thread -> {
                    try {
                        thread.start();
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
        Instant end = Instant.now();
        System.out.println("Elapsed Time: " + Duration.between(start, end).toMillis() + ".ms");
    }

    static void runInParallelStream(Runnable task) {
        Instant start = Instant.now();
        IntStream.range(0, 10)
                .parallel()
                .mapToObj(value -> Thread.ofVirtual().start(task))
//                .mapToObj(value -> new Thread(task))
                .forEach(thread -> {
                    try {
//                        thread.start();
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

        Instant end = Instant.now();
        System.out.println("Elapsed Time: " + Duration.between(start, end).toMillis() + ".ms");
    }
}
