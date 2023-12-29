package com.vedha.collections.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaMethodReference {

	public static Integer add(Integer a, Integer b) {

		return a + b;
	}

	public Integer sub(Integer a, Integer b) {

		return a - b;
	}

	public static void main(String[] args) {

		// Method Reference Should Be ClassName::MethodName

		// Calling Class Static Method
		BiFunction<Integer, Integer, Integer> biFunction = LambdaMethodReference::add;
		System.out.println(biFunction.apply(12, 12));

		// Calling Class Object
		LambdaMethodReference lambdaMethodReference = new LambdaMethodReference();
		BiFunction<Integer, Integer, Integer> biFunction2 = lambdaMethodReference::sub;
		System.out.println(biFunction2.apply(12, 10));

		BiFunction<Integer, Integer, Integer> biFunction3 = new LambdaMethodReference()::sub;
		System.out.println(biFunction3.apply(12, 10));

		// Calling Same Input Argument Class Methods
		Function<String, Integer> function = String::length; // s.length(); return length of given string
		System.out.println(function.apply("Vedha"));

		// Using Lambda
		String[] arg = { "A", "C", "D", "B", "a", "b", "d", "c" };
		Arrays.sort(arg, (o1, o2) -> o1.compareToIgnoreCase(o2));

		System.out.println(Arrays.toString(arg));

		// Method Reference
		Arrays.sort(arg, String::compareTo);
		System.out.println(Arrays.toString(arg));

		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("Apple");
		arrayList.add("Banana");
		arrayList.add("Mango");
		arrayList.add("Grapes");
		arrayList.add("Apple");

		// Using Lambda for Hash Set Constructor
		Function<ArrayList<String>, HashSet<String>> function2 = t -> new HashSet<String>(t);
		System.out.println(function2.apply(arrayList));

		// Using Method Reference for Hash Set Constructor
		Function<ArrayList<String>, HashSet<String>> function3 = HashSet<String>::new;
		System.out.println(function3.apply(arrayList));

	}

}
