package com.vedha.collections.sets;

import java.util.Collections;
import java.util.LinkedHashSet;

public class LinkedSets {

	public static void main(String[] args) {

		// LinkedHashSet Will not be in duplicate -> insert as hash code, it will be in
		// insert ordered
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("Vedha");
		linkedHashSet.add("Master");
		linkedHashSet.add("1");

		System.out.println(linkedHashSet); // ordered

		linkedHashSet.add("Leo");

		String min = Collections.min(linkedHashSet);
		System.out.println(min);
	}
}
