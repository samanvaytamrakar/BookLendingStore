package com.bookLend.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

	
	public static Date returnCurrentDate() {
		return new Date(System.currentTimeMillis());		
	}
		
	public static java.sql.Date getSQLformattedDate(Date date){
		return new java.sql.Date(date.getTime());
	}
	
	public static Date formattedDate(String date,String format) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.parse(date);
	}
	
	public static int getDaysBetweenDates(String start,String end) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date one = dateFormat.parse(start);
		Date two = dateFormat.parse(end);
		long diff = Math.abs(one.getTime()-two.getTime());
		int days = (int)(diff / (1000*60*60*24));
		return days;
	}
	
	public static int getDaysBetweenDates(Date start,Date end) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date one = dateFormat.parse(dateFormat.format(start));
		Date two = dateFormat.parse(dateFormat.format(end));
		
		long diff = Math.abs(one.getTime()-two.getTime());
		int days = (int)(diff / (1000*60*60*24));
		return days;
	}
	
	
}
