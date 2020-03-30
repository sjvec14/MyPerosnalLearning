package com.learning.java8basics.collections;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.learning.java8basics.modelclases.Book;

public class CollectionsTrainer {

	public void configureStream(ArrayList<Book> bookList) {

		System.out.println("This is my input book list" + bookList);
		// Method to work on the filtering an the Map methods of stream
		List<Book> javaBookList = bookList.stream()
				.filter(book -> book.getChapterName().contains("java"))
				.collect(Collectors.toList());

		System.out.println("This is my java book list post filter"
				+ javaBookList);

		List<Book> updatedBookList = bookList.stream().map(book -> {
			book.setChapterName("New" + book.getChapterName());
			return book;
		}).collect(Collectors.toList());

		System.out.println("This is my java book list post map function"
				+ updatedBookList);
	}

	public void processStream() {
		
		Stream<Integer> intStream = Stream.of(0,1,2,3,5,6,8,5,11,18,33); 
		List<Integer> evenNumberList = intStream.filter(i -> i%2 ==0).collect(Collectors.toList());
		System.out.println("This is my list of even number demonstrating the collect () "
				+ evenNumberList.toString());
		System.out.println("This is size list of even number demonstrating the count () "
				+ evenNumberList.stream().count());
		
		Stream<Integer> sampleIntStream = Stream.of(1,25,87,66,55,42,33,3654,895);
		List<Integer> sortedNumberList = sampleIntStream.sorted((a,b) -> -a.compareTo(b)).collect(Collectors.toList());
		System.out.println("This is my list of sorted number demonstrating the sort () "
				+ sortedNumberList.toString());
		
		Stream<Integer> testIntStream = Stream.of(10,250,87,606,550,402,303,654,8095);
		Stream<Integer> testIntegerStream = Stream.of(10,250,87,606,550,402,303,654,8095);
		Optional<Integer> maxNumber = testIntStream.max((a,b) -> -a.compareTo(b));
		Optional<Integer> minNumber = testIntegerStream.min((a,b) -> -a.compareTo(b));
		System.out.println("This is the maximum # in the stream " + maxNumber);
		System.out.println("This is the maximum # in the stream " + minNumber);
	
		Stream<Integer> sampIntStream = Stream.of(10,250,87,606,550,402,303,654,8095);
		Object[] sampleArray = sampIntStream.toArray();
		
		Arrays.stream(sampleArray).forEach(System.out::println); 
	
	}
}
