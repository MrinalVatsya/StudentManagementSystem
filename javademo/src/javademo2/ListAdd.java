package javademo2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class ListAdd {
	public static void main(String[] args) {
		//		List<Integer> list1 = Arrays.asList(1,2,3,4);
		//		List<Integer> result = list1.stream().map(entity->{
		//			List<Integer> list2 = new ArrayList<>();
		//			list2.add(entity.intValue());
		//			System.out.println(list2);
		//			return entity;}).collect(Collectors.toList());		
		//		System.out.println(result);
//		String finalStartDateTime = "20181121T030000Z";
//		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddTHHmmssZ");
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddTHHmmssZ", Locale.ENGLISH);
//		LocalDate date = LocalDate.parse(finalStartDateTime, formatter);
//		System.out.println(date);
//		
		
//		String string = "January 2, 2010";
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
//		LocalDate date = LocalDate.parse(string, formatter);
//		System.out.println(date); // 2010-01-02
		
	//	DateTimeFormatter oldPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	//	DateTimeFormatter newPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");

//		String input = "xyz";
//		LocalDateTime datetime = LocalDateTime.parse(input, oldPattern);
//		String output = datetime.format(newPattern);
		
		DateTimeFormatter old = DateTimeFormatter.ofPattern("HH:mm");
		DateTimeFormatter new1 = DateTimeFormatter.ofPattern("HHmmss");
		String input1 = "03:21";
		LocalTime oldju = LocalTime.parse(input1, old) ;
		String newju = oldju.format(new1);
		System.out.println(newju);
		
		//DateTimeFormatter newDateFormatter = DateTimeFormatter.ofPattern("yyyyMMddT");
		
		String startDate = "2018-11-20";
		String startTime = "12:30";
		String combinedDateTime = startDate+startTime;
		System.out.println(combinedDateTime);
		//LocalDateTime dateTime = LocalDateTime.parse(text, formatter);
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
		df.setTimeZone(tz);
		//String nowAsISO = df.format(date);
		//System.out.println(nowAsISO);
	}
}
