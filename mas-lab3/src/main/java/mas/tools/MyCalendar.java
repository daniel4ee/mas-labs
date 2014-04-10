package mas.tools;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class MyCalendar {
	
	private static Calendar cal = GregorianCalendar.getInstance();
	
	static {
		cal.setLenient(false);
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
	}
	
	public static Date getBirthDate(int day, int month, int year) {
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.MONTH, month -1);
		cal.set(Calendar.YEAR, year);
		return cal.getTime();
	}

}
