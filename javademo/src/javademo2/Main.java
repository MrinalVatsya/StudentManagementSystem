/**
 * 
 */
package javademo2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Main {
	
	private static final String DATE_FORMAT = "dd-M-yyyy";
	private static final String TIME_FORMAT = "hh:mm:ss";
	
	public static void main(String[] args) throws ParseException {
		TimeZone tzJapan = TimeZone.getTimeZone("Asia/Tokyo");
		Calendar cld = Calendar.getInstance(tzJapan);
		//System.out.println(cld.get(Calendar.HOUR_OF_DAY));
		
//        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
//        String dateInString = "22-01-2015";
//        Date date = formatter.parse(dateInString);
		
		//Date String..
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy", Locale.JAPAN);
		formatter.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
		 
		String dateInString = "22-01-2015"; 
		Date date = formatter.parse(dateInString);
		String formattedDateString = formatter.format(date);
		System.out.println(formattedDateString);
		
		//Time String..
		SimpleDateFormat form = new SimpleDateFormat("hh:mm:ss", Locale.JAPAN);
		form.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
		
		String timeString = "11:43:40";
		Date formattedTimeString = form.parse(timeString);
		System.out.println(form.format(formattedTimeString));
	}
}