package com.vedha.collections.sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class HashSets {

	public static void main(String[] args) {

		// HashSet Will not be in duplicate -> insert as hash code, it will be in
		// unordered
		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("Vedha");
		hashSet.add("Master");
		hashSet.add("Leo");

		System.out.println(hashSet); // unordered

		hashSet.add("Leo");

		System.out.println(hashSet);

		String max = Collections.max(hashSet);
		System.out.println(max);

		// To List
		List<String> arrayList = new ArrayList<>(hashSet);
		System.out.println(arrayList);

		Collections.sort(arrayList);
		System.out.println("Sorted hashset by using list : " + arrayList);

		LinkedHashSet<String> hashSet2 = new LinkedHashSet<>(hashSet);
		System.out.println(hashSet2);

		Object clone = hashSet2.clone();

		System.out.println(hashSet2.equals(clone));

	}
}
