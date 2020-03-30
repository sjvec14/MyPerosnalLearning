package com.learning.java8basics.predefinedFunctionalInterfaces;

import java.util.function.BinaryOperator;

public class BinaryOperatorTrainer {

	BinaryOperator<Integer> additionbop = (a, b) -> {
		return a + b;
	};
	

	public void processBinaryOperator(int a, int b) {

		System.err.println("Hi i am working with the apply() method of the Biary operator");
		System.out.println(additionbop.apply(a,b));
	}

}
