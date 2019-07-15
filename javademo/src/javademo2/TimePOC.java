/**
 * 
 */
package javademo2;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author mrinalvatsya
 *
 */
public class TimePOC {
	public static void main(String[] args) throws ParseException {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
		dateTimeFormatter.withZone(ZoneId.of("Asia/Tokyo"));
		dateTimeFormatter.withZone(ZoneOffset.UTC);
				String time = "23:29:30";
				//String date = "26-10-2018";
				LocalDate date = LocalDate.now(); 
				System.out.println(date);
				LocalTime time1 = LocalTime.parse(time, dateTimeFormatter);
				LocalDateTime dateTime = date.atTime(time1);
				dateTime = dateTime.plusMinutes(540L);
				System.out.println(dateTime);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				 String formatDateTime = dateTime.format(formatter);
				 
				 System.out.println(formatDateTime);
				
				System.out.println("Current Time in Japan is :- "+ time1);
				LocalTime time2 = time1.minusMinutes(540L);
				System.out.println("UTC Time is :- "+time2);
		
			//	String dateInDb =  date;
				String timeInDb = time1.toString();
				
				LocalTime convertTime = LocalTime.parse(timeInDb, dateTimeFormatter);
				LocalTime timeInUI = convertTime.plusMinutes(540L);
				System.out.println("Time Displayed On UI :- " + dateTimeFormatter.format(convertTime));
				String timeStoredInUI = timeInUI.toString();
				
				ZoneId z = ZoneId.of("Asia/Kolkata");
				LocalDateTime ldt = LocalDateTime.now(z);
				System.out.println(z.getRules().getOffset(ldt));
				
				ZoneOffset offset = z.getRules().getOffset(ldt);
				System.out.println(offset.getTotalSeconds());
				int TotalSeconds = offset.getTotalSeconds();
				int minutes = TotalSeconds/60;
				System.out.println(minutes);

//		ZoneId fromTimeZone = ZoneId.of("Asia/Kolkata");
//		ZoneId toTimeZone = ZoneId.of("Asia/Tokyo");
//		LocalDateTime today = LocalDateTime.now();//Current time
//		System.out.println("Today is :- " + today);
//		//Zoned date time at source timezone
//		ZonedDateTime currentISTime = today.atZone(fromTimeZone);      
//
//		//Zoned date time at target timezone
//		ZonedDateTime currentETime = currentISTime.withZoneSameInstant(toTimeZone);
//
//		System.out.println(dateTimeFormatter.format(currentISTime));
//		System.out.println(dateTimeFormatter.format(currentETime));
//		
//		SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/mm/yyyy");
//		TimeZone etTimeZone = TimeZone.getTimeZone("Asia/Tokyo"); //Target timezone
//        
//        Date currentDate = new Date();
//        System.out.println(currentDate);
//         
//        System.out.println(FORMATTER.format(currentDate));  //Date in current timezone
//         
//        FORMATTER.setTimeZone(etTimeZone);
//         
//        System.out.println(FORMATTER.format(currentDate));  //Date in target timezone
	}
}
