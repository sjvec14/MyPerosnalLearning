package com.learning.java8basics.predefinedFunctionalInterfaces;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorTrainer {

	UnaryOperator<String> uop = s -> {
		return s + " The following string is concatinated";
	};

	UnaryOperator<String> secondFunction = s -> {
		return s + " to the existing String";
	};

	Function<String, String> andThenUop = uop.andThen(secondFunction);

	Function<String, String> composeUop = uop.compose(secondFunction);

	public void processUnaryOperator(String testString) {
		System.err
				.println("Hi i am working with the apply() method of the unary operator");
		System.out.println(uop.apply(testString));
		System.err
				.println("Hi i am working with the andThen() method of the unary operator");
		System.out.println(andThenUop.apply(testString));
		System.err
				.println("Hi i am working with the compose() method of the unary operator");
		System.out.println(composeUop.apply("bye"));
	}

}
