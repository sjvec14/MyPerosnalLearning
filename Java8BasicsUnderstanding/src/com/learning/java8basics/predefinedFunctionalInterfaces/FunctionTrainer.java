package com.learning.java8basics.predefinedFunctionalInterfaces;

import java.util.function.Function;

public class FunctionTrainer {

	Function<Integer, Integer> squareFunction = i -> i * i;
	Function<Integer, Integer> sumFunction = i -> i + i;
	Function<Integer, Integer> andThenFunction = squareFunction.andThen(sumFunction);
	Function<Integer, Integer> composeThenFunction = squareFunction.compose(sumFunction);
	Function<Integer, Integer> identityFunction = Function.identity();
	

	public void processIntegerInput(int testNumber) {

		System.err.println("Hi i am working with the apply() method of the Function");
		System.out.println(squareFunction.apply(testNumber));
		System.err.println("Hi i am working with the andThen() method of the Function");
		System.out.println(andThenFunction.apply(testNumber));
		System.err.println("Hi i am working with the compose() method of the Function");
		System.out.println(composeThenFunction.apply(testNumber));
		System.err.println("Hi i am working with the identity() method of the Function");
		System.out.println(identityFunction.apply(testNumber));
		
	}
}
