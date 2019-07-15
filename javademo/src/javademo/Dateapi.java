package javademo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.*;
public class Dateapi {
	public static void main(String[] args) {
		LocalDate l = LocalDate.now();
		System.out.println(l);
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		System.out.println(tomorrow);
		
		int six = LocalTime.parse("06:30").getHour();
		System.out.println(six);
		
		LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
		System.out.println(sevenThirty);
		
		System.out.println(LocalDateTime.now());
		
		//zone date and time
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		System.out.println(allZoneIds);
		
		ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");
		
		LocalDate initialDate = LocalDate.parse("2007-05-10");
		LocalDate finalDate = initialDate.plus(Period.ofDays(5));
		int five = (int) ChronoUnit.DAYS.between(initialDate , finalDate);
		System.out.println(five);
		
		//date time formatting
		LocalDateTime localDateTime = LocalDateTime.of(2015, Month.JANUARY, 25, 6, 30);
		String localDateString = localDateTime.format(DateTimeFormatter.ISO_DATE);
		
		System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
		localDateTime
		  .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
		  .withLocale(Locale.UK));
	}
}
