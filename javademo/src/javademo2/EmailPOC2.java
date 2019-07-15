
/**
 * 
 */
package javademo2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author mrinalvatsya
 *
 */
/**
 * 
 */

/**
 * @author mrinalvatsya
 *
 */

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.MailcapCommandMap;
import javax.activation.MimetypesFileTypeMap;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.apache.poi.util.SystemOutLogger;

public class EmailPOC2 {

	public EmailPOC2() {
	}

	public static int getMinutes()

	{

		ZoneId zoneId = ZoneId.of("Etc/UTC");

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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
		EmailPOC2 email = new EmailPOC2();

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String sampleStartDate = "2019-01-27";

		String sampleEndDate = "2019-01-27";

		LocalDate startDate = LocalDate.parse(sampleStartDate, dateFormatter);

		LocalDate endDate = LocalDate.parse(sampleEndDate, dateFormatter);

		String sampleStartTime = "11:15";

		String sampleEndTime = "12:45";

		//finding object according to start time and start date..

		LocalDate usertTimeZoneStartDate = getUserTimeZoneDate(startDate,sampleStartTime);

		String userTimeZoneStartTime = getUserTimeZoneTime(startDate, sampleStartTime);

		//convert them to a combined form of 20181120T053000Z

		DateTimeFormatter newDateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

		DateTimeFormatter newTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		
		//meeting time and date formatter
		DateTimeFormatter meetingDateFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
		
		//finding Day of Meeting 
		DayOfWeek meetingDay = usertTimeZoneStartDate.getDayOfWeek();
		//find start date of meeting using formatter..
		String finalStartDate = usertTimeZoneStartDate.format(newDateFormatter);
		LocalDate meetingOldStartDate = LocalDate.parse(finalStartDate, newDateFormatter);
		String newStartDate = meetingOldStartDate.format(meetingDateFormatter);
		newStartDate = newStartDate+" ("+meetingDay+")";//MEETING START DATE
		
		DateTimeFormatter newMeetingTimeFormatter = DateTimeFormatter.ofPattern("HHmm");
		LocalTime finalLocalStartTime = LocalTime.parse(userTimeZoneStartTime, newTimeFormatter);
		
		DateTimeFormatter UTCTimeFormatter = DateTimeFormatter.ofPattern("HHmmss");

		LocalTime userStartTime = LocalTime.parse(userTimeZoneStartTime, newTimeFormatter);//HH:mm
		String finalStartTime = userStartTime.format(UTCTimeFormatter);
		String meetingStartTime = finalLocalStartTime.format(newMeetingTimeFormatter);//Start Time of meeting
		meetingStartTime = meetingStartTime+" Hours"+"(IST)";
		
		String finalStartDateTime = finalStartDate + "T" + finalStartTime + "Z";

		//System.out.println(finalStartDateTime+"//////////////////////////////////////////");
		LocalDate usertTimeZoneEndDate = getUserTimeZoneDate(endDate,sampleEndTime);

		String userTimeZoneEndTime = getUserTimeZoneTime(endDate, sampleEndTime);

		//convert them to a combined form of 20181120T053000Z

		String finalEndDate = usertTimeZoneEndDate.format(newDateFormatter);
		LocalTime finalLocalEndTime = LocalTime.parse(userTimeZoneEndTime, newTimeFormatter);
		String finalEndTime = finalLocalEndTime.format(UTCTimeFormatter);
		String finalEndDateTime = finalEndDate + "T" + finalEndTime + "Z";

		//System.out.println("FinalEndDateTime is : " + finalEndDateTime+"/////////////////////////////////////////////");


		String venue = "Conference Hall";
		String dateOfMeeting = newStartDate;
		String timeOfMeeting = meetingStartTime; 
		String companyDescription = "Motherson Sumi Systems Limited (MSSL) ";
		String meetingType = "Meeting of the Board of Directors";
		String from = "mrinal.vatsya@mind-infotech.com";
		String to = "hiteshm.dabral@mind-infotech.com";
		String subject = "Meeting of Directors";
		
		//Meeting Start Date : newStartDate variable is used..
		//Meeting start time : meetingStartTime
		
		System.out.println("body Date: "+timeOfMeeting);
		System.out.println("header Date: "+finalStartDateTime);
		

		email.send(subject, finalStartDateTime, finalEndDateTime, venue, dateOfMeeting, timeOfMeeting, companyDescription, meetingType, from, to);
	}
	
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

		public void send(String subject, String startDate, String endDate, String venue, String dateOfMeeting, String timeOfMeeting, String companyDescription, String meetingType, String from, String to) throws Exception {

			try {

				String body =  "Dear Sir/Madam,"
						+ "\\nPlease note that a " + meetingType + "of " + companyDescription
						+ "will be held on " + dateOfMeeting + " as per\\nschedule below:\\n\\n"
						+ "Date Of Meeting       :      " + dateOfMeeting + "\\nTime of Meeting       :     " + timeOfMeeting 
						+ "\\nVenue                           :      " 
						+ venue +  "\\nThe agenda for the meeting will be sent separately.\\n\\n"
						+ "You are requested to kindly make it convenient to attend the meeting.\\n\\n"
						+ "Best regards,\\nFor Motherson Sumi Systems Limited\\n"
						+ "\\n\\n\\n\r\n";

				
				
				Properties prop = new Properties();
				prop.put("mail.smtp.host", "smtp.int.motherson.com");

				Session session = Session.getDefaultInstance(prop, null);
				// Define message
				MimeMessage message = new MimeMessage(session);
				message.addHeaderLine("method=REQUEST");
				message.addHeaderLine("charset=UTF-8");
				message.addHeaderLine("component=VEVENT");
				

				message.setFrom(new InternetAddress(from));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject(subject);//subject can be changed from ui
				
				StringBuffer sb = new StringBuffer();
				System.out.println("StartDate : " + startDate);
				System.out.println("EndDate : " + endDate);
				StringBuffer buffer = sb.append("BEGIN:VCALENDAR\n" +
						"PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n" +
						"VERSION:2.0\n" +
						"METHOD:REQUEST\n" +
						"BEGIN:VEVENT\n" +
						"ATTENDEE;ROLE=CHAIR;PARTSTAT=ACCEPTED;RSVP=TRUE:MAILTO:" + to + "\n" + 
						"ORGANIZER:MAILTO:" + from + "\n" + 
						"DTSTART: " + startDate + "\n" + 
						"DTEND: " + endDate + "\n" + 
						"LOCATION: " + venue + "\n" + 
						"TRANSP:TRANSPARENT\n" +
						"SEQUENCE:0\n" +
						"UID:90\n" +
						"DTSTAMP:20190122T000000Z\n" +
						"CATEGORIES:Meeting\n" +
						"DESCRIPTION:" + body +  
						"SUMMARY:Test meeting request\n" +
						"PRIORITY:5\n" +
						"CLASS:PUBLIC\n" +
						"STATUS:CONFIRMED\n" + 
						"BEGIN:VALARM\n" +
						"TRIGGER:PT1440M\n" +
						"ACTION:DISPLAY\n" +
						"DESCRIPTION:Reminder\n" +
						"FREEBUSY;FBTYPE=BUSY-UNAVAILABLE:"+startDate+"/"+endDate+"\n" + 
						"TRIGGER;RELATED=START:-PT00H15M00S\n"+
						"END:VALARM\n" +
						"END:VEVENT\n" +
						"END:VCALENDAR");

				// Create the message part
				BodyPart messageBodyPart = new MimeBodyPart();
				
				// Fill the message
				messageBodyPart.setHeader("Content-Class", "urn:content-  classes:calendarmessage");
				messageBodyPart.setHeader("Content-ID", "calendar_message");
				messageBodyPart.setDataHandler(new DataHandler(
						new ByteArrayDataSource(buffer.toString(), "text/calendar;method=REQUEST")));// very important

				// Create a Multipart
				Multipart multipart = new MimeMultipart();

				// Add part one
				multipart.addBodyPart(messageBodyPart);

				// Put parts in message
				message.setContent(multipart);
				
				// send message
				Transport.send(message);
				
				//session.getFolder(url);
			} catch (MessagingException me) {
				me.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
