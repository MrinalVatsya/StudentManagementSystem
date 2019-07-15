package javademo2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 
 */

/**
 * @author MRINAL VATS
 *
 */
public class DateTimePOC {
	public static int getMinutes()

	{

		ZoneId zoneId = ZoneId.of(ZoneId.SHORT_IDS.get("IST"));

		ZoneId z = ZoneId.of(zoneId.toString());

		LocalDateTime ldt = LocalDateTime.now(z);



		ZoneOffset offset = z.getRules().getOffset(ldt);

		int TotalSeconds = offset.getTotalSeconds();

		int minutes = TotalSeconds/60;

		return minutes;

	}



	public static LocalDate getUserTimeZoneDate(LocalDate date, String time)

	{

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");

		LocalTime meetingTime = LocalTime.parse(time, dateTimeFormatter);

		LocalDateTime dateTime = date.atTime(meetingTime);

		long minutes = getMinutes();

		LocalDateTime meetingStartUtcTime = dateTime.plusMinutes(minutes);

		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String dateInUI = meetingStartUtcTime.format(dateformatter);

		LocalDate finalDateInUi = LocalDate.parse(dateInUI);

		return finalDateInUi;

	}



	public static String getUserTimeZoneTime(LocalDate date, String time)

	{

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");

		LocalTime meetingTime = LocalTime.parse(time,dateTimeFormatter);

		LocalDateTime dateTime = date.atTime(meetingTime);

		long minutes = getMinutes();

		LocalDateTime meetingStartUtcTime = dateTime.plusMinutes(minutes);

		DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HH:mm");

		String timeInUI = meetingStartUtcTime.format(timeformatter);

		return timeInUI;

	}
	
	public static void main(String[] args) {

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String sampleStartDate = "2018-11-20";

		String sampleEndDate = "2018-11-20";

		LocalDate startDate = LocalDate.parse(sampleStartDate, dateFormatter);

		LocalDate endDate = LocalDate.parse(sampleEndDate, dateFormatter);



		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

		String sampleStartTime = "20:51";

		String sampleEndTime = "21:30";



		LocalTime startTime = LocalTime.parse(sampleStartTime, timeFormatter);

		LocalTime endTime = LocalTime.parse(sampleStartTime, timeFormatter);



		//finding object according to start time and start date..

		LocalDate usertTimeZoneStartDate = getUserTimeZoneDate(startDate,sampleStartTime);

		String userTimeZoneStartTime = getUserTimeZoneTime(startDate, sampleStartTime);

		//convert them to a combined form of 20181120T053000Z

		DateTimeFormatter newDateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

		DateTimeFormatter newTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");

		String finalStartDate = usertTimeZoneStartDate.format(newDateFormatter);
		LocalTime finalLocalStartTime = LocalTime.parse(userTimeZoneStartTime, newTimeFormatter);

		int startHours = finalLocalStartTime.getHour();
		String startHoursInString = String.format("%02d", startHours);
		
		int startMinutes = finalLocalStartTime.getMinute();
		String startMinutesInString = String.format("%02d", startMinutes);
		
		String finalStartTime = "T" + startHoursInString + startMinutesInString + "00Z" ;

		String finalStartDateTime = finalStartDate + finalStartTime;

		System.out.println(finalStartDateTime+"/////////////////////////////////////////////");



		//for end Time



		LocalDate usertTimeZoneEndDate = getUserTimeZoneDate(endDate,sampleEndTime);

		String userTimeZoneEndTime = getUserTimeZoneTime(endDate, sampleEndTime);

		//convert them to a combined form of 20181120T053000Z

		String finalEndDate = usertTimeZoneEndDate.format(newDateFormatter);
		LocalTime finalEndLocalTime =  LocalTime.parse(userTimeZoneEndTime, newTimeFormatter);

		int endHours = finalEndLocalTime.getHour();
		String endHoursInString = String.format("%02d", endHours);

		int endMinutes = finalEndLocalTime.getMinute();
		String endMinutesInString = String.format("%02d", endMinutes);

		String finalEndTime = "T" + endHoursInString + endMinutesInString + "00Z" ;

		String finalEndDateTime = finalEndDate + finalEndTime;

		System.out.println("FinalEndDateTime is : " + finalEndDateTime+"/////////////////////////////////////////////");


	}
}


