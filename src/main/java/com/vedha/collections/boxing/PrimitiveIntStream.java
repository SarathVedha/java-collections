package com.vedha.collections.boxing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveIntStream {

    public static void print(String value) {
        System.out.println("String: " + value);
    }

    public static void print(Object value) {
        System.out.println("Object: " + value);
    }

    public static void main(String[] args) {

        // IntStream used for primitive int values, and it does not have any null values, and no extra boxing cost.
        IntStream.of(1, 2, 3, 4, 5)
                .forEach(System.out::println);

        int sum = IntStream.range(1, 5).sum();
        System.out.println("Sum: " + sum);

        // Convert IntStream to Stream<Integer>
        IntStream.of(1, 2, 3, 4, 5)
                .boxed()
                .map(Integer::toBinaryString).forEach(System.out::println);

        // Convert IntStream to List<Integer>
        List<Integer> list = IntStream.rangeClosed(0, 5).boxed().toList();
        System.out.println(list);

        // Convert int array to IntStream
        int[] intArray = { 1, 2, 3, 4, 5 };
        IntStream stream = Arrays.stream(intArray);
        stream.forEach(System.out::println);

        Integer[] integerArray = { 1, 2, 3, 4, 5 };
        Stream<Integer> stream1 = Arrays.stream(integerArray);
        stream1.forEach(System.out::println);

        // Convert List<Integer> to IntStream
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        IntStream intStream = integerList.stream().mapToInt(Integer::intValue);
        intStream.forEach(System.out::println);

        // Sum in Stream<Integer>
        List<Integer> integerList1 = List.of(1, 2, 3, 4, 5);
        int sum1 = integerList1.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum1);

        // Sum in Stream<Integer> using reduce
        integerList1.stream().reduce(Integer::sum).ifPresent(System.out::println);

        PrimitiveIntStream.print(null); // String: null
        PrimitiveIntStream.print(20); // Object: 20
        PrimitiveIntStream.print("Hello"); // String: Hello
        PrimitiveIntStream.print(true); // Object: true
    }
}
