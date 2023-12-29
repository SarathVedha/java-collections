package com.vedha.collections.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class ArraysDemo {

	public static String var;

	public static void main(String[] args) {

		int[] arr = { 3, 9, 6, 2, 0 };

		for (int i = 0; i < arr.length; i++) {

			System.out.println(arr[i]);
		}

		Arrays.sort(arr);

		System.out.println("After Sort");

		for (int i : arr) {

			System.out.println(i);
		}

		String[] names = { "Sara", "Vedha", "Master" };

		for (String string : names) {

			System.out.println(string);
		}

//		Arrays.sort(names);

		System.out.println("After Sort ASEC");

		for (String string : names) {

			System.out.println(string);
		}

		Arrays.sort(names, (o1, o2) -> {

			String s1 = (String) o1;
			String s2 = (String) o2;

			int compareTo = s1.compareTo(s2);
			if (compareTo > 0) {

				return -1;
			} else if (compareTo < 0) {

				return 1;
			} else {

				return 0;
			}
		});

		System.out.println("After Sort DESC");

		for (String string : names) {

			System.out.println(string);
		}

		Comparator<Object> comparator = (o1, o2) -> {

			String name1 = (String) o1;
			String name2 = (String) o2;

			if (name1.length() > name2.length()) {

				return 1;
			} else if (name1.length() < name2.length()) {

				return -1;
			} else {

				return 0;
			}
		};

		Arrays.sort(names, comparator);

		System.out.println("After Length Sort");

		for (String string : names) {

			System.out.println(string);
		}
		
		
		Function<String, Integer> function = t -> {
			
			t = t.toLowerCase();
			Integer result = -1;
			for (int i = 0; i < t.length(); i++) {
				
				char charAt = t.charAt(i);
				for (int j = i+1; j < t.length(); j++) {
					
					if (charAt == t.charAt(j)) {
						
						return i;
					}
				}
				
				
			}
			
			return result;
		};
		
		Integer apply = function.apply("Sarthh");
		System.out.println(apply);
		

	}

}
