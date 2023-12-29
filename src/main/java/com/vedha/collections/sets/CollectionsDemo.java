package com.vedha.collections.sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class CollectionsDemo {

	public static void main(String[] args) {
		
		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("Vedha");
		hashSet.add("Tree");
		hashSet.add("Leo");
		
		System.out.println(hashSet);
		
		hashSet.add("Leo");
		
		System.out.println(hashSet);
		
		String max = Collections.max(hashSet);
		System.out.println("Max : " + max);
		
		ArrayList<String> arrayList = new ArrayList<>(hashSet);
		System.out.println("Converted TO LIst : " + arrayList);
		
		Collections.sort(arrayList);
		System.out.println("Sorted : " + arrayList);
		
		// Insertion Order
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("Vedha");
		linkedHashSet.add("Tree");
		linkedHashSet.add("Leo");
		linkedHashSet.add("Leo");
		
		System.out.println(linkedHashSet);
		
		// Sorted
		TreeSet<String> set = new TreeSet<>(linkedHashSet);
		System.out.println(set);
	}
}
