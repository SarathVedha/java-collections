package com.vedha.collections.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedLists {

	public static void main(String[] args) {

		// Insert and Delete is fast
		// Search and get is slow
		LinkedList<String> list = new LinkedList<>();

		/*
		 * Insert
		 */
		list.add("Mersal");
		list.add("Master");

		// Insert in between is easy mention index
		list.add(1, "Leo");

		// last means give the size of list
		list.add(list.size(), "Theri");

		list.addFirst("Sarath");
		list.addLast("Rabin");

		list.offer("Vedha");
		list.offerFirst("Jack");
		list.offerLast("Jhon");

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

		System.out.println(list.getFirst());

		System.out.println(list.getLast());

		System.out.println(list.peek());

		System.out.println(list.peekFirst());

		System.out.println(list.peekLast());

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

		list.offer("Leo");
		list.remove(list.indexOf("Leo"));
		System.out.println(list);

		list.remove("Master");
		System.out.println(list);

		list.removeIf(t -> {
			return t.equalsIgnoreCase("VEDHA");
		});

		list.removeFirst();
		System.out.println(list);

		list.removeLast();
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
