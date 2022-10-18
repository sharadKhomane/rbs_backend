package com.yash.rbs.util;

import java.sql.Timestamp;
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

}
