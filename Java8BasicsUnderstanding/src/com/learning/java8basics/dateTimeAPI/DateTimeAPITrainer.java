package com.learning.java8basics.dateTimeAPI;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimeAPITrainer {
	
	public void workWithLocalDate(){
		
		LocalDate ld = LocalDate.now();
		System.out.println("Current date as per local date.now() " + ld);
		System.out.println("day of year as per local date.now() " + ld.getEra());
		System.out.println("Current year as per local date.now() " + ld.getYear());
		System.out.println("day of year as per local date.now() " + ld.getMonth());
		System.out.println("day of year as per local date.now() " + ld.getDayOfYear());
		System.out.println("day of year as per local date.now() " + ld.getMonth());
		System.out.println("date after 90 days " + ld.plusDays(90));
		System.out.println("day of june 02 1991 " + LocalDate.parse("1991-06-02").getDayOfWeek());
		System.out.println("is  1991 leap year " + LocalDate.parse("1991-06-02").isLeapYear());
		
	}
	
	public void workWithLocalDateTime(){
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("Current date and time as per local datetime.now() " + ldt);
		System.out.println(" date and time after 21900 hours" + ldt.plusHours(2400));
	}

}
