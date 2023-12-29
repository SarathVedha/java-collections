package com.vedha.collections.optional;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {

		String name = "Vedha";
		String name2 = "Vedha";

		// Creates Empty Optional Object
		Optional<Object> empty = Optional.empty();
		System.out.println(empty);
		System.out.println(empty.isPresent());
		System.out.println(empty.isEmpty());

		// Arguments As Value and generate optional object, argument as null throw
		// built in exception
		Optional<String> of = Optional.of(name);
		System.out.println(of);

		// Same as above but argument as null means gives empty optional object
		Optional<String> ofNullable = Optional.ofNullable(name2);
		System.out.println(ofNullable);

		// Optional Object value Is In Null gives default or else value
		String orElse = ofNullable.orElse("Null Found Da");
		System.out.println(orElse);

		// Same as above but argument as consumer functions interface
		String orElseGet = ofNullable.orElseGet(() -> "Null Found Daa");
		System.out.println(orElseGet);

		// If Value Is null throws build in exception
		String orElseThrow = ofNullable.orElseThrow();
		System.out.println(orElseThrow);

		// Same as above but throws custom exception
		String orElseThrow2 = ofNullable.orElseThrow(() -> new RuntimeException("Null Value Dude."));
		System.out.println(orElseThrow2);

		// RealTime Use Case
		String value = "Demo  ";

		Optional<String> ofNullable2 = Optional.ofNullable(value)
				// Filter Accepts Predicate Interface boolean check conditions
				// true means return value otherwise return empty optional
				.filter(t -> t.startsWith("D"))
				// Map Accepts Function Interface Returns same String Objects
				.map(String::trim);

		System.out.println(ofNullable2);
		
	}
}
