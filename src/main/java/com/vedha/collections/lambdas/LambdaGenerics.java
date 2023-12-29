package com.vedha.collections.lambdas;

@FunctionalInterface
public interface LambdaGenerics<T> {

	// Generic Will Get The Object Declare, while instance initiated time.
	T operators(T t);

	static <T> T operators1(T t) {

		System.out.println("Lambda Generics Static Method");
		return t;
	}

	default T operators2(T t) {

		System.out.println("Lambda Generics Default Method");
		return t;
	}
}
