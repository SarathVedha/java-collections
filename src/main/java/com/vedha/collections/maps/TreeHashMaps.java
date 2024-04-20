package com.vedha.collections.maps;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeHashMaps {

	public static void main(String[] args) {

		// It Will Sort as ASEC with Key, Because in Map Key is unique.
		TreeMap<String, String> treeMap = new TreeMap<>();
		treeMap.put("Vedha", "Mass");
		treeMap.put("Leo", "Therika");
		treeMap.put("Bigil", "Pudichi");
		// treeMap.put(null, null); // Null Pointer Exception
		treeMap.put(null, null);

		System.out.println(treeMap);

		// Sorted as DESC Using Comparator in Constructor
		TreeMap<String, String> treeMap2 = new TreeMap<>((o1, o2) -> {
			String s1 = (String) o1;
			String s2 = (String) o2;

			if (s1.compareTo(s2) > 0) {

				return -1;
			} else if (s1.compareTo(o2) < 0) {

				return 1;
			} else {

				return 0;
			}
		});

		treeMap2.put("Vedha", "Mass");
		treeMap2.put("Leo", "Therika");
		treeMap2.put("Bigil", "Pudichi");

		System.out.println(treeMap2);

		Set<Entry<String, String>> entrySet = treeMap2.entrySet();
		Iterator<Entry<String, String>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();

			System.out.println(entry);
		}

		NavigableMap<String, String> descendingMap = treeMap2.descendingMap();
		System.out.println(descendingMap);

	}
}
