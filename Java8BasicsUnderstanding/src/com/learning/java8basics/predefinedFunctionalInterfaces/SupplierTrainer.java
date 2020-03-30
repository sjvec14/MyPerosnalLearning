package com.learning.java8basics.predefinedFunctionalInterfaces;

import java.util.function.Supplier;

public class SupplierTrainer {

	Supplier<String> greetingSupplier = () -> {
		return "Welcome to the supplier Concept of the java 8";
	};

	public void getGreetingContent() {

		System.out.println(greetingSupplier.get());

	}

}
