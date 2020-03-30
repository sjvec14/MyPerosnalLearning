package com.learning.java8basics.predefinedFunctionalInterfaces;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BiPredicateTrainer {
	
	BiPredicate<Integer, Integer> graterThanBiPredicate = (a,b) -> {
		return a > b;
	};
	BiPredicate<Integer, Integer> divisorBiPredicate = (a,b) -> {
		
		return a%b ==0 ;
		
	};
	
	BiPredicate<Integer, Integer> negateBiPredicate = graterThanBiPredicate.negate();
	BiPredicate<Integer, Integer> andBiPredicate = graterThanBiPredicate.and(divisorBiPredicate);
	BiPredicate<Integer, Integer> orBiPredicate = graterThanBiPredicate.or(divisorBiPredicate);

	
public void processIntegerInput(int a, int b) {
		
		System.err.println("Hi i am working with the test() method of the Bipredicate with string");
		System.out.println(graterThanBiPredicate.test(a,b));
		System.err.println("Hi i am working with the negate() method of the Bipredicate with string");
		System.out.println(negateBiPredicate.test(a,b));
		System.err.println("Hi i am working with the and() method of the Bipredicate with string");
		System.out.println(andBiPredicate.test(15,2));
		System.err.println("Hi i am working with the or() method of the Bipredicate with string");
		System.out.println(orBiPredicate.test(a,b));
		
		
		
	}
	

}
