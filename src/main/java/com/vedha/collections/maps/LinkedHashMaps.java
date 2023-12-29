package com.vedha.collections.maps;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LinkedHashMaps {

	public static void main(String[] args) {

		// Follows Insert Order
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("101", "Vedha");
		linkedHashMap.put("102", "Leo");
		linkedHashMap.put("103", "Master");
		linkedHashMap.put("104", "Bigil");

		System.out.println(linkedHashMap);

		Set<Entry<String, String>> entrySet = linkedHashMap.entrySet();
		Iterator<Entry<String, String>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();

			String key = entry.getKey();
			if (Integer.parseInt(key) >= 102) {

				entry.setValue("Leo");
			}
		}

		System.out.println(linkedHashMap);
	}
}
