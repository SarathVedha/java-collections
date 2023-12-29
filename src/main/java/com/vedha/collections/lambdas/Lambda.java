package com.vedha.collections.lambdas;

@FunctionalInterface
public interface Lambda {

	// Functional Interface Gives Functional Programming in java

	// Use @FunctionalInterface to use

	// @FunctionalInterface Will Support one Abstract Method and Many static and
	// default
	// method
	String operator(String string);

	static void operators(String string) {

		System.out.println("Static Method Pa : " + string);
	}

	static void operators2(String string) {

		System.out.println("Static2 Method Pa : " + string);
	}

	default void Operators3(String string) {

		System.out.println("Default Method Pa : " + string);
	}

	default void Operators4(String string) {

		System.out.println("Default2 Method Pa : " + string);
	}

}
