package com.learning.java8basics.predefinedFunctionalInterfaces;

import java.util.ArrayList;
import java.util.function.Consumer;

import com.learning.java8basics.modelclases.Book;

public class ConsumerTrainer {

	Consumer<ArrayList<Book>> arraylistConsumer = b -> {
		for (Book book : b) {
			System.out.println("The books before consumer call "
					+ book.toString());
			book.setChapterName("updated chapterName is "
					+ book.getChapterName());
		}
	};

	Consumer<ArrayList<Book>> bookNameChangeConsumer = b -> {
		for (Book book : b) {
			if (book.getChapterNumer() == 1) {
				System.out.println("The books before consumer call "
						+ book.toString());
				book.setChapterName("updated the chpater name in the andThenConsumer");
			}
		}
	};

	Consumer<ArrayList<Book>> andThenConsumer = arraylistConsumer
			.andThen(bookNameChangeConsumer);

	public void processArrayList(ArrayList<Book> al) {

		arraylistConsumer.accept(al);
		for (Book book : al) {
			System.out.println("The books after consumer call "
					+ book.toString());
		}

		andThenConsumer.accept(al);
		for (Book book : al) {
			System.out.println("The books after consumer call "
					+ book.toString());
		}

	}

}
