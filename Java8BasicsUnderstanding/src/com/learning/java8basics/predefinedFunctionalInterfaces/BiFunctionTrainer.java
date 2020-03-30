package com.learning.java8basics.predefinedFunctionalInterfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionTrainer {
	
	BiFunction<Integer, Integer , Integer> multiplyBiFunction = (a,b) -> a*b;
	Function<Integer, Integer> squareFunction = a -> a*a;
	BiFunction<Integer, Integer , Integer> andThenFunction = multiplyBiFunction.andThen(squareFunction);
	
	public void processIntegerInput(int a, int b) {

		System.err.println("Hi i am working with the apply() method of the BiFunction");
		System.out.println(multiplyBiFunction.apply(a, b));
		System.err.println("Hi i am working with the andThen() method of the BiFunction");
		System.out.println(andThenFunction.apply(a, b));
	}

}
