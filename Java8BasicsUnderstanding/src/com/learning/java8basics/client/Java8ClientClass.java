package com.learning.java8basics.client;

import java.util.ArrayList;
import java.util.Arrays;

import com.learning.java8basics.collections.CollectionsTrainer;
import com.learning.java8basics.dateTimeAPI.DateTimeAPITrainer;
import com.learning.java8basics.functionalInterfaces.ISampleFunctionalInterface;
import com.learning.java8basics.modelclases.Book;
import com.learning.java8basics.predefinedFunctionalInterfaces.BiConsumerTrainer;
import com.learning.java8basics.predefinedFunctionalInterfaces.BiFunctionTrainer;
import com.learning.java8basics.predefinedFunctionalInterfaces.BiPredicateTrainer;
import com.learning.java8basics.predefinedFunctionalInterfaces.BinaryOperatorTrainer;
import com.learning.java8basics.predefinedFunctionalInterfaces.ConsumerTrainer;
import com.learning.java8basics.predefinedFunctionalInterfaces.FunctionTrainer;
import com.learning.java8basics.predefinedFunctionalInterfaces.PredicateTrainer;
import com.learning.java8basics.predefinedFunctionalInterfaces.SupplierTrainer;
import com.learning.java8basics.predefinedFunctionalInterfaces.UnaryOperatorTrainer;

public class Java8ClientClass {

	public static void main(String[] args) {

		ArrayList<Book> bookAl = new ArrayList<Book>();
		bookAl.add(new Book(1, "java 8 "));
		bookAl.add(new Book(2, "java webservice"));
		bookAl.add(new Book(3, "python basics"));
		bookAl.add(new Book(4, "C# basics"));
		bookAl.add(new Book(5, "C++ basics"));
		System.out.println("Hi I have started learning Java 8 Features");

		// Starting off with the lambda implementation

		ISampleFunctionalInterface.printWelcomeNote();

		ISampleFunctionalInterface sampleInterface = s -> System.out
				.println("Hello " + s + " welcome to java 8 tutorial");

		sampleInterface.greetUser("Jawahar");

/*		// Working with predicates
		System.err.println("*****************************************");
		System.err.println("Starting off with the Predicate Trainer");
		System.err.println("*****************************************");
		PredicateTrainer pt = new PredicateTrainer();
		pt.processStringInput("Hi This is jawahar");
		System.err.println("*****************************************");
		System.err.println("Ending with the Predicate Trainer");
		System.err.println("*****************************************");

		// working with Functions
		System.err.println("*****************************************");
		System.err.println("Starting off with the Functions Trainer");
		System.err.println("*****************************************");
		FunctionTrainer ft = new FunctionTrainer();
		ft.processIntegerInput(3);
		System.err.println("*****************************************");
		System.err.println("Ending with the Functions Trainer");
		System.err.println("*****************************************");

		// working with Consumers
		System.err.println("*****************************************");
		System.err.println("Starting off with the Consumers Trainer");
		System.err.println("*****************************************");
		ConsumerTrainer ct = new ConsumerTrainer();
		ct.processArrayList(bookAl);
		System.err.println("*****************************************");
		System.err.println("Ending with the consumers Trainer");
		System.err.println("*****************************************");

		// Working with suppliers
		System.err.println("*****************************************");
		System.err.println("Starting off with the Supplier Trainer");
		System.err.println("*****************************************");
		SupplierTrainer st = new SupplierTrainer();
		st.getGreetingContent();
		System.err.println("*****************************************");
		System.err.println("Ending with the Supplier Trainer");
		System.err.println("*****************************************");

		// working with BiPredicate
		System.err.println("*****************************************");
		System.err.println("Starting off with the BiPredicate Trainer");
		System.err.println("*****************************************");
		BiPredicateTrainer bpt = new BiPredicateTrainer();
		bpt.processIntegerInput(15, 5);
		System.err.println("*****************************************");
		System.err.println("Ending with the BiPredicate Trainer");
		System.err.println("*****************************************");

		// working with BiFunction
		System.err.println("*****************************************");
		System.err.println("Starting off with the BiFunction Trainer");
		System.err.println("*****************************************");
		BiFunctionTrainer bft = new BiFunctionTrainer();
		bft.processIntegerInput(15, 5);
		System.err.println("*****************************************");
		System.err.println("Ending with the BiFunction Trainer");
		System.err.println("*****************************************");

		// working with BiConsumer
		System.err.println("*****************************************");
		System.err.println("Starting off with the BiFunction Trainer");
		System.err.println("*****************************************");
		BiConsumerTrainer bct = new BiConsumerTrainer();
		bct.processArrayList(bookAl, 1);
		System.err.println("*****************************************");
		System.err.println("Ending with the BiFunction Trainer");
		System.err.println("*****************************************");

		// working with unaryOperator
		System.err.println("*****************************************");
		System.err.println("Starting off with the Unary Operator Trainer");
		System.err.println("*****************************************");
		UnaryOperatorTrainer uopT = new UnaryOperatorTrainer();
		uopT.processUnaryOperator("Hello");
		System.err.println("*****************************************");
		System.err.println("Ending with the Unary Operator Trainer");
		System.err.println("*****************************************");

		// working with BinaryOperator
		System.err.println("*****************************************");
		System.err.println("Starting off with the Unary Operator Trainer");
		System.err.println("*****************************************");
		BinaryOperatorTrainer bopt = new BinaryOperatorTrainer();
		bopt.processBinaryOperator(7, 14);
		System.err.println("*****************************************");
		System.err.println("Ending with the Unary Operator Trainer");
		System.err.println("*****************************************");

		// working with Collections
		System.err.println("*****************************************");
		System.err.println("Starting off with the Collections Trainer");
		System.err.println("*****************************************");
		CollectionsTrainer ct = new CollectionsTrainer();
		ct.configureStream(bookAl);
		ct.processStream();
		System.err.println("*****************************************");
		System.err.println("Ending with the Collections Trainer");
		System.err.println("*****************************************");*/

		// working with Collections
		System.err.println("*****************************************");
		System.err.println("Starting off with the Collections Trainer");
		System.err.println("*****************************************");
		DateTimeAPITrainer dtat = new DateTimeAPITrainer();
		dtat.workWithLocalDate();
		dtat.workWithLocalDateTime();
		System.err.println("*****************************************");
		System.err.println("Ending with the Collections Trainer");
		System.err.println("*****************************************");
	}

}
