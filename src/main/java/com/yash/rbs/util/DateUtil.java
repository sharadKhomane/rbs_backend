package com.yash.rbs.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DateUtil {
	
	public static Timestamp getCurrentDateTime() {
		LocalDateTime now = LocalDateTime.now();
		Timestamp today = java.sql.Timestamp.valueOf(now);
		return today;
	}

	public static String convertTimeStampDateString(long time) {
		// TODO Auto-generated method stub
		Timestamp t = new Timestamp(time);
		Date d = t;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String format = formatter.format(d);
		return format;
	}
	
	public static Date getStringtoDate(String sDate1) 
	{
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
			System.out.println(sDate1 + "\t" + date1);
		} catch (Exception e) {

		}
		return date1;
	}

}
