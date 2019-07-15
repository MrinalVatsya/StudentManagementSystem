/**
 * 
 */
package javademo2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author mrinalvatsya
 *
 */
public class UtcTime {
	public static Date dateFromUTC(Date date){
		return new Date(date.getTime());//offset to be added to get Local Time..
	}

	public static Date dateToUTC(Date date){
		
		return new Date(date.getTime() - Calendar.getInstance().getTimeZone().getOffset(date.getTime()));//offset to be subtracted to get UTC Time..
	}

	public static void main(String[] args) throws ParseException {
		
		final String formattedString = "25/10/18";
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		TimeZone tzJapan = TimeZone.getTimeZone("Asia/Tokyo");
		Calendar cld = Calendar.getInstance(tzJapan);
		System.out.println(cld.get(Calendar.HOUR_OF_DAY)+ ":" + cld.get(Calendar.MINUTE) + ":" + cld.get(Calendar.SECOND));
	
		//extract date from string..
		Date date = df.parse(formattedString);
		
		System.out.println("UTC Time is :- " + df.format(dateToUTC(date)));
		//System.out.println(date.getTime());
		//System.out.println("OffSet is :- " + Calendar.getInstance().getTimeZone().getOffset(date.getTime()));
//		System.out.println("Current Date and Time is :- " + df.format(date));//for printing current date and time..
//
//		System.out.println("UTC Time is :- " + df.format(dateToUTC(date)));
//
//		System.out.println("Local Time is :- " + df.format(dateFromUTC(date)));

		//System.out.println(LocalTime.now());
	}
}