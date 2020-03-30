package com.learning.java8basics.functionalInterfaces;

public interface ISampleFunctionalInterface {

	public void greetUser(String user);
	
	public static void printWelcomeNote() {
		
		System.out.println("Hi I am in to the static method of the interface");
		
	}
	
}
