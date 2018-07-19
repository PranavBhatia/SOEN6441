package com.soen6441;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.DateFormatter;

public class ThreadLocalDateFormatter {

	public static void main(String[] args) {

		ThreadLocal<DateFormatter> threadLocal = ThreadLocal
				.withInitial(() -> new DateFormatter(DateFormat.getDateInstance()));

		SimpleDateFormat simpleDateFormat = (SimpleDateFormat) threadLocal.get().getFormat();
		simpleDateFormat.applyPattern("dd-MMM-yyyy");

		System.out.println(simpleDateFormat.format(new Date()));
	}

}
