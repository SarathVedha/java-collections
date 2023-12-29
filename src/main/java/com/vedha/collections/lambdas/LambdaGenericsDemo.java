package com.vedha.collections.lambdas;

public class LambdaGenericsDemo {

	public static void main(String[] args) {

		LambdaGenerics<String> lambdaGenerics = t -> {

			System.out.println("Inside Lambda Generics Method");

			return t.concat(" Epudi");
		};

		String operators = lambdaGenerics.operators("Hi");
		System.out.println(operators);

		String operators1 = LambdaGenerics.operators1("Hi Static");
		System.out.println(operators1);

		String operators2 = lambdaGenerics.operators2("Hi Default");
		System.out.println(operators2);

	}
}
