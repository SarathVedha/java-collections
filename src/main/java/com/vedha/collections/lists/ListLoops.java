package com.vedha.collections.lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Spliterator;

public class ListLoops {

	public static void main(String[] args) {

		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("Leo");
		arrayList.add("Master");
		arrayList.add("Theri");
		arrayList.add("Beast");

		System.out.println(arrayList);

		for (String string : arrayList) {

			System.out.println(string);
		}

		// iterator is old having minimal functions
		Iterator<String> iterator = arrayList.iterator();
		while (iterator.hasNext()) {

			String next = iterator.next();

//			System.out.println(next);

			if (next.equals("Leo")) {

				iterator.remove();
			}

		}

		System.out.println(arrayList);

		// listIterator is having more functions
		ListIterator<String> listIterator = arrayList.listIterator();

		while (listIterator.hasNext()) {

			String next = listIterator.next();
			if (next.equals("Beast")) {

				listIterator.set("Beast Movie");
				int previousIndex = listIterator.previousIndex();
				System.out.println(arrayList.get(previousIndex));
			}

		}

		System.out.println(arrayList);

		Spliterator<String> spliterator = arrayList.spliterator();
		long exactSizeIfKnown = spliterator.getExactSizeIfKnown();
		System.out.println(exactSizeIfKnown);

	}
}
