package com.vedha.collections.sets;

import java.util.TreeSet;

public class TreeSets {

	public static void main(String[] args) {

		// TreeSet Will not be in duplicate -> insert as hash code, it will be in
		// Sorted as ASEC, HetroGenous Object not allowed, null will not accept
		// because its sorting
		TreeSet<Object> treeSet = new TreeSet<>();
		treeSet.add("Vedha");
		treeSet.add("Master");
		treeSet.add("Leo");
		treeSet.add(new CollectionsDemo()); // HetroGenous

		System.out.println(treeSet);

	}
}
