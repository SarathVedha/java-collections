package com.vedha.collections.lambdas;

public class LambdaDemo {

	public static void main(String[] args) {

		Lambda lambda = string -> string;

		System.out.println(lambda.operator("Hi Lambda"));

		// Existing Instance
		lambda = string -> string.concat("Edited");

		System.out.println(lambda.operator("Hi Lambda "));

		// New Instance
		Lambda lambda2 = string -> {
			return string;
		};

		System.out.println(lambda2.operator("Hi Lambdas"));

		// Static Way
		Lambda.operators("Hi Lambda");

		Lambda.operators2("Hi Lambdas");

		lambda2.Operators3("Hi Lambda");

		lambda2.Operators4("Hi Lambda");

	}
}
