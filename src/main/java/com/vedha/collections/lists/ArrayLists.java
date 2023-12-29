package com.vedha.collections.lists;

import java.util.ArrayList;
import java.util.List;

public class ArrayLists {

	public static void main(String[] args) {

		//Search and Get Is Fast
		//Insert and Delete is slow
		ArrayList<String> list = new ArrayList<>();

		/*
		 * Insert
		 */
		list.add("Mersal");
		list.add("Master");
		list.add("Beast");
		list.add("Leo");
		list.add("Vedha");

		// Insert in between is easy mention index
		list.add(1, "Leo");

		// last means give the size of list
		list.add(list.size(), "Theri");

		System.out.println("Insert : " + list);

		/*
		 * Select
		 */

		System.out.println(list.contains("Leo"));

		System.out.println(list.get(1));

		// Get The Index Of The Value In List
		System.out.println(list.indexOf("Leo"));
		System.out.println(list.get(list.indexOf("Master")));

		System.out.println(list.lastIndexOf("Leo"));

		/*
		 * Update
		 */
		list.set(0, "Mersal Movie");
		System.out.println(list);

		list.set(list.indexOf("Leo"), "Leo Movie");
		System.out.println(list);

		/*
		 * Delete
		 */
		list.remove(0);
		System.out.println(list);

		list.remove(list.indexOf("Leo"));
		System.out.println(list);

		list.remove("Master");
		System.out.println(list);

		list.removeIf(t -> {
			return t.equalsIgnoreCase("VEDHA");
		});

		System.out.println(list);
		
		/*
		 * Copy
		 */
		List<String> list2 = new ArrayList<>(list);
		System.out.println(list2);
		
		List<String> list3 = new ArrayList<>();
		list3.addAll(list2);
		System.out.println(list3);
		
		List<String> list4 = new ArrayList<>();
		list4.add("Vijay");
		list4.add("Vijay Sethupathi");
		list4.add("Karthick");
		
		System.out.println(list4);
		
		list.addAll(list4);
		System.out.println(list);
		
		list2.addAll(2, list4);
		System.out.println(list2);
		
		Object clone = list.clone();
		System.out.println(clone);
		
	}

}
