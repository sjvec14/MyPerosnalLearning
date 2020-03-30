package com.learning.java8basics.predefinedFunctionalInterfaces;

import java.util.function.Predicate;

public class PredicateTrainer {
	
	Predicate<String> stringPredicate = s -> s.length() >5 ;
	Predicate<String> stringcharIdentifierPredicate = s -> s.charAt(0) == 'H' ;
	Predicate<String> negateStringPredicate = stringPredicate.negate();
	Predicate<String> andStringPredicate = stringPredicate.and(stringcharIdentifierPredicate);
	Predicate<String> orStringPredicate = stringPredicate.or(stringcharIdentifierPredicate);
	Predicate<String> equalStringPredicate = Predicate.isEqual("This is My Test String");
	String testString = "This is My Test String";
	
	public void processStringInput(String str) {
		
		System.err.println("Hi i am working with the test() method of the predicate with string");
		System.out.println(stringPredicate.test(str));
		System.err.println("Hi i am working with the negate() method of the predicate with string");
		System.out.println(negateStringPredicate.test(str));
		System.err.println("Hi i am working with the and() method of the predicate with string");
		System.out.println(andStringPredicate.test("Hello all"));
		System.err.println("Hi i am working with the or() method of the predicate with string");
		System.out.println(orStringPredicate.test("Jawahar"));
		System.err.println("Hi i am working with the isEquals() method of the predicate with string");
		System.out.println(equalStringPredicate.test(testString));
		
	}
	
	

}
