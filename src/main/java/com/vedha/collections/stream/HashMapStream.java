package com.vedha.collections.stream;

import java.util.*;
import java.util.function.Function;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

record Details(Long id, String name) {
}

public class HashMapStream {

    public static void main(String[] args) {

        Random from = Random.from(RandomGenerator.getDefault());

        Details vedha = new Details(from.nextLong(), "Vedha");
        Details vijay = new Details(from.nextLong(), "vijay");
        Details theri = new Details(from.nextLong(), "theri");
        Details theri2 = new Details(from.nextLong(), "theri");
        Details master = new Details(from.nextLong(), "master");
        Details master2 = new Details(from.nextLong(), "master");

        List<Details> allDetails = List.of(vedha, vijay, master, master2, theri, theri2);
        System.out.println(allDetails);
        System.out.println(allDetails.stream().distinct().toList());

        // Distinct a dto with hashset
        Set<String> filter = HashSet.newHashSet(allDetails.size());
        System.out.println(allDetails.stream().filter(detail -> filter.add(detail.name())).toList());

        // ------------------------------------------------------------------------
        List<Map<String, String>> names = List.of(Map.of("name", "vedha", "id", String.valueOf(from.nextLong())),
                Map.of("name", "theri", "id", String.valueOf(from.nextLong())),
                Map.of("name", "theri", "id", String.valueOf(from.nextLong())),
                Map.of("name", "master", "id", String.valueOf(from.nextLong())),
                Map.of("name", "master", "id", String.valueOf(from.nextLong())));
        System.out.println(names);
        System.out.println(names.stream().distinct().toList());

        Set<String> filters = HashSet.newHashSet(names.size());
        System.out.println(names.stream().filter(map -> filters.add(map.get("name"))).toList());

        List<Integer> integers = List.of(1, 2, 2, 3, 4, 4, 4, 5);
        // Function.identity() return same input value
        Map<Integer, Long> collect = integers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        LinkedHashMap<Integer, Long> ascOrder = collect.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (newValue, oldValue) -> newValue, LinkedHashMap::new));
        System.out.println(ascOrder);

        LinkedHashMap<Integer, Long> descOrder = collect.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (newValue, oldValue) -> newValue, LinkedHashMap::new));
        System.out.println(descOrder);

        Map<Integer, String> integerStringMap = Map.
                of(1, "Vedha", 2, "Master", 3, "Theri", 4, "Vijay", 5, "VJS");

        Map<Integer, String> loopFilter = new HashMap<>();
        for (Map.Entry<Integer, String> entry : integerStringMap.entrySet()) {

            if (!entry.getValue().startsWith("V")) {

                loopFilter.put(entry.getKey(), entry.getValue());
            }
        }

        System.out.println("loopFilter = " + loopFilter);

        Map<Integer, String> filterStream = integerStringMap.entrySet()
                .stream()
                .filter(integerStringEntry -> integerStringEntry.getValue().startsWith("V"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("filterStream = " + filterStream);
    }
}
