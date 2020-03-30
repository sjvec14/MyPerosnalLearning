package com.learning.java8basics.modelclases;

public class Book {

	int chapterNumer;
	public Book(int chapterNumer, String chapterName) {
		super();
		this.chapterNumer = chapterNumer;
		this.chapterName = chapterName;
	}

	String chapterName;

	@Override
	public String toString() {
		return "Book [chapterNumer=" + chapterNumer + ", chapterName="
				+ chapterName + "]";
	}

	public int getChapterNumer() {
		return chapterNumer;
	}

	public void setChapterNumer(int chapterNumer) {
		this.chapterNumer = chapterNumer;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

}
