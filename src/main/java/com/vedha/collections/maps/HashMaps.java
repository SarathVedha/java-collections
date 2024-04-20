package com.vedha.collections.maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMaps {

	public static void main(String[] args) {

		// HashMap Key are no duplicate values are collections both key and value are
		// entry with no duplicates.
		HashMap<Integer, String> hashMap = new HashMap<>();
		hashMap.put(101, "Vedha");
		hashMap.put(102, "Master");
		hashMap.put(102, "Leo");
		hashMap.put(103, "Theri");
		hashMap.put(104, "Vijay");
		hashMap.put(105, "Bigil");

		System.out.println(hashMap);

		String string = hashMap.get(102);
		System.out.println(string);

		String remove = hashMap.remove(103);
		System.out.println(remove);

		boolean remove2 = hashMap.remove(102, "Leo");
		System.out.println(remove2);

		Set<Integer> keySet = hashMap.keySet();
		System.out.println(keySet);

		Iterator<Integer> iterator = keySet.iterator();
		while (iterator.hasNext()) {

			Integer integer = (Integer) iterator.next();
			System.out.println(integer);

		}

		Collection<String> values = hashMap.values();
		System.out.println(values);

		Iterator<String> iterator2 = values.iterator();
		while (iterator2.hasNext()) {

			String string2 = (String) iterator2.next();
			System.out.println(string2);
		}

		Set<Entry<Integer, String>> entrySet = hashMap.entrySet();
		System.out.println(entrySet);

		Iterator<Entry<Integer, String>> iterator3 = entrySet.iterator();
		while (iterator3.hasNext()) {
			// Map Oda Inner Class Entry
			Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iterator3.next();
			System.out.println(entry);

			if (entry.getKey() == 105) {

				entry.setValue("Sarath");
			}
		}

		System.out.println(hashMap);

		// String Object will have hashcode and equals method
		// HashMap will use hashcode and equals method to check the duplicate values
		HashMap<String, String> hashMap2 = new HashMap<>();
		hashMap2.put(new String("HI"), "Vedha");
		hashMap2.put(new String("HI"), "Leo"); // it will replace the value

		System.out.println(hashMap2);
	}

}
