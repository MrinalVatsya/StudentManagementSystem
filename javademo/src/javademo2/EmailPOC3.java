/**
 * 
 */
package javademo2;

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

public class EmailPOC3 {
	public static void main(String[] args) {
		try {
				Properties prop = new Properties();
				prop.put("mail.smtp.host", "smtp.int.motherson.com");
				String body = "mrinal";

				Session session = Session.getDefaultInstance(prop, null);
				// Define message
				MimeMessage message = new MimeMessage(session);
				message.addHeaderLine("method=REQUEST");
				message.addHeaderLine("charset=UTF-8");
				message.addHeaderLine("component=VEVENT");
				
				String from = "Mrinal.Vatsya@mind-infotech.com";
				String to = "hiteshm.dabral@mind-infotech.com";
				String subject = "Meeting Test1212";
				message.setFrom(new InternetAddress(from));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject(subject);//subject can be changed from ui
				
				String venue = "Vineet Road";
				StringBuffer sb = new StringBuffer();
				String methodType = "REQUEST";
				String status = "CONFIRMED";
				String meetingId = "121";
				
				Integer sequenceNo = 0;
				String sequence = sequenceNo.toString();
				boolean cancelMeeting = false;
				if(cancelMeeting)
				{
					message.setSubject("Canceled : "+subject);
					methodType = "CANCEL";
					status = "CANCELLED";
				}
					
				StringBuffer buffer = sb.append("BEGIN:VCALENDAR\n" +
						"PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n" +
						"VERSION:2.0\n" +
						"METHOD:"+ methodType + "\n" +
						"BEGIN:VEVENT\n" +
						"ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:"+to+"\n" +
						"ORGANIZER:MAILTO:" + from + "\n" + 
						"DTSTART: " + "20190429T053000Z" + "\n" + 
						"DTEND: " + "20190429T060000Z" + "\n" + 
						"LOCATION: " + venue + "\n" + 
						"TRANSP:OPAQUE\n" +
						"SEQUENCE:" + sequence + "\n" +
						"UID:"+meetingId+"\n" +
						"DTSTAMP:20190429T000000Z\n" +
						"CATEGORIES:Meeting\n" +
						"DESCRIPTION:" + body +  
						"SUMMARY: Meeting\n" +
						"PRIORITY:5\n" +
						"CLASS:PUBLIC\n" +
						"STATUS:"+ status + "\n" + 
						"BEGIN:VALARM\n" +
						"TRIGGER:PT1440M\n" +
						"ACTION:DISPLAY\n" +
						"DESCRIPTION:Reminder\n" +
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
						new ByteArrayDataSource(buffer.toString(), "text/calendar")));// very important

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
