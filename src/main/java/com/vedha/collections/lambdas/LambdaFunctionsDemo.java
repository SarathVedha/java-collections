package com.vedha.collections.lambdas;

import java.time.LocalDateTime;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaFunctionsDemo {

	public static void main(String[] args) {

		// Function<input, return> having apply method
		Function<String, Integer> function = t -> {

			return t.length();
		};

		System.out.println("Printing Length Of String");
		Integer apply = function.apply("Vedha");
		System.out.println(apply);

		// Consumer method for print something no return
		Consumer<String> consumer = t -> System.out.println(t);

		consumer.accept("Hi");

		// Supplier No Input But Return time denote and get the value
		Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
		System.out.println(supplier.get());

		// Accepts One Value Predicate Input
		Predicate<String> predicate = t -> t.equalsIgnoreCase("Vedha");
		System.out.println("Is Same : " + predicate.test("Vedha"));

		// Bi Means Two
		// Two Input and Return
		BiFunction<String, String, String> biFunction = (t, u) -> t.concat(" " + u);
		System.out.println(biFunction.apply("Hi", "Vedha"));

		// Function Then
		String apply2 = biFunction.andThen(t -> t.concat(" Summa")).apply("Hi", "Vedha");
		System.out.println("Function Then :" + apply2);

		// Two Input
		BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t.concat(" " + u));
		biConsumer.accept("Hi", "Vedha");

		// Accepts Two Input
		BiPredicate<String, String> biPredicate = (t, u) -> t.equalsIgnoreCase(u);
		System.out.println("Is Same : " + biPredicate.test("Vedha", "Vedha"));

		// Predicate And Method
		boolean test = biPredicate.and((t, u) -> t.startsWith("V")).test("vedha", "Vedha");
		System.out.println("Predicate With And : " + test);

		boolean test2 = biPredicate.or((t, u) -> t.startsWith("V")).test("Vedha", "Vedha");
		System.out.println("Predicate With Or : " + test2);
	}
}
