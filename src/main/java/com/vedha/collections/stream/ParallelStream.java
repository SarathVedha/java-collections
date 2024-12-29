package com.vedha.collections.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStream {

    public static void main(String[] args) {

        System.out.println("--------Inconsistency");
        // Inconsistency
        List<Integer> integerList = new ArrayList<>(); // Common Variable
        for (int i = 0; i < 10; i++) {

            IntStream.range(1, 30).boxed().parallel().limit(20).forEach(integerList::add);
            System.out.println(integerList);
            System.out.println(integerList.size());
            integerList.clear();
        }

        System.out.println("--------Sync");
        // synchronizedList
        List<Integer> syncIntegers = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 10; i++) {

            IntStream.range(1, 30).boxed().parallel().limit(20).forEach(syncIntegers::add);
            System.out.println(syncIntegers);
            System.out.println(syncIntegers.size());
            syncIntegers.clear();
        }

        System.out.println("--------------------Ordered");
        // Ordered
        Stream.iterate(1, integer -> integer + 1)
                .parallel().limit(20).forEachOrdered(integerList::add);
        System.out.println(integerList);
        System.out.println(integerList.size());

        System.out.println("-----------------Stream Internal Collect Method toList() un-modifiable.");
        List<Integer> list = Stream.iterate(1, integer -> integer + 1)
                .parallel().limit(20)
                .toList(); // direct list or collection will give un-modifiable.
        System.out.println(list);
        System.out.println(list.size());

        System.out.println("-----------------Stream Internal Collect Method collect(Collectors.toList()) modifiable list");
        List<Integer> list2 = Stream.iterate(1, integer -> integer + 1)
                .parallel().limit(20)
                .collect(Collectors.toList()); // collect method will give modifiable list or collections.
        System.out.println(list2);
        System.out.println(list2.size());

        System.out.println("-----------------Stream Internal Collect Method collect() modifiable list");
        List<Integer> list3 = Stream.iterate(1, integer -> integer + 1)
                .parallel().limit(20)
                .collect(() -> new ArrayList<>(), (listInteger, integerData) -> listInteger.add(integerData), (leftList, rightList) -> leftList.addAll(rightList));
        System.out.println(list3);
        System.out.println(list3.size());

        System.out.println("-----------------Stream Internal Collect Method .collect(ArrayList::new, ArrayList::add, ArrayList::addAll) modifiable list");
        for (int i = 0; i < 10; i++) {

            List<Integer> lists = Stream.iterate(1, integer -> integer + 1)
                    .parallel().limit(20)
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
            System.out.println(lists);
            System.out.println(lists.size());
        }
    }
}
