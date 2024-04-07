package com.vedha.collections.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class HashMapProblems {

	public static void main(String[] args) {

		// Follows Insert Order
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("101", "Vedha");
		linkedHashMap.put("102", "Leo");
		linkedHashMap.put("103", "Master");
		linkedHashMap.put("104", "Bigil");

		System.out.println(linkedHashMap);

		String s = "VedhaahdeVDA";

		s.chars().forEach(value -> {
			System.out.println((char) value);
		});

		List<Character> collect = s.chars().mapToObj(value -> (char) value).collect(Collectors.toList());
		HashMap<Character, Integer> map = new HashMap<>();

		collect.forEach(t -> {
			if (map.containsKey(t)) {

				Integer integer = map.get(t);
				map.replace(t, integer + 1);
			} else {

				map.put(t, 1);
			}
		});
		System.out.println(map);
		map.clear();

		ListIterator<Character> listIterator = collect.listIterator();
		while (listIterator.hasNext()) {
			Character character = listIterator.next();
			if (map.containsKey(character)) {

				Integer integer = map.get(character);
				map.replace(character, integer + 1);
			} else {

				map.put(character, 1);
			}
		}
		System.out.println(map);

		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		Iterator<Entry<Character, Integer>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Character, Integer> entry = iterator.next();
			if (entry.getValue() > 1) {

				System.out.println("Duplicate Value : " + entry);
			} else {

				System.out.println("Unique : " + entry);
			}
		}

	}
}
