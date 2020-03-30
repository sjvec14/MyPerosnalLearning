package com.learning.java8basics.predefinedFunctionalInterfaces;

import java.util.ArrayList;
import java.util.function.BiConsumer;



import java.util.function.Consumer;

import com.learning.java8basics.modelclases.Book;

public class BiConsumerTrainer {

	
	BiConsumer<ArrayList<Book> , Integer> arraylistConsumer = (a,b) -> {
		for (Book book : a) {
			if(book.getChapterNumer()== b){
			System.out.println("The books before Biconsumer call "
					+ book.toString());
			book.setChapterName("updated chapterName is "
					+ book.getChapterName());
			}
		}
	};
	
	
	BiConsumer<ArrayList<Book> , Integer> secondArraylistConsumer = (c,d) -> {
		for (Book book : c) {
			if(book.getChapterName().contains("updated")){
			System.out.println("The books before second Biconsumer call "
					+ book.toString());
			book.setChapterNumer(d);
			}
		}
	};
	
	BiConsumer<ArrayList<Book> , Integer> andThenBiConsumer = arraylistConsumer
			.andThen(secondArraylistConsumer);
	
	public void processArrayList(ArrayList<Book> bookAl , int a){
		
		arraylistConsumer.accept(bookAl , a);
		for (Book book : bookAl) {
			System.out.println("The books after Biconsumer call "
					+ book.toString());
		}
		
		andThenBiConsumer.accept(bookAl, 12);
		for (Book book : bookAl) {
			if(book.getChapterNumer() == 12){
				System.out.println("The books after second Biconsumer call is " + book.toString());
			}
		}
		
		
		
		
	}
}
