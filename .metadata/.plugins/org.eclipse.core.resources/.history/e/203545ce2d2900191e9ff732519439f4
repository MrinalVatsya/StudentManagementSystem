package javademo2;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.PropertySet;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.BasePropertySet;
import microsoft.exchange.webservices.data.core.enumeration.property.BodyType;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.core.enumeration.search.LogicalOperator;
import microsoft.exchange.webservices.data.core.enumeration.service.ConflictResolutionMode;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.core.service.item.Item;
import microsoft.exchange.webservices.data.core.service.schema.EmailMessageSchema;
import microsoft.exchange.webservices.data.core.service.schema.ItemSchema;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.EmailAddress;
import microsoft.exchange.webservices.data.property.complex.MessageBody;
import microsoft.exchange.webservices.data.search.FindItemsResults;
import microsoft.exchange.webservices.data.search.ItemView;
import microsoft.exchange.webservices.data.search.filter.SearchFilter;

public class EWSJavaAPI {

	public static ExchangeService connectViaExchangeAutodiscover(String email, String password) {
		ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
		try {

			service.setCredentials(new WebCredentials(email, password));
			service.setUrl(new URI("https://owa.motherson.com/ews/Exchange.asmx"));
			service.setTraceEnabled(true);
			ItemView view = new ItemView (10);
			// To read unread message from mailbox..
			SearchFilter acceptedSearchFilter = new SearchFilter.ContainsSubstring(ItemSchema.Subject, "Accepted");
			SearchFilter declinedSearchFilter = new SearchFilter.ContainsSubstring(ItemSchema.Subject, "Declined");
			SearchFilter tentativeSearchFilter = new SearchFilter.ContainsSubstring(ItemSchema.Subject, "Tentative");
			SearchFilter sf = new SearchFilter.SearchFilterCollection(LogicalOperator.Or, tentativeSearchFilter, acceptedSearchFilter,  declinedSearchFilter);
			SearchFilter readEmails = new SearchFilter.IsEqualTo(EmailMessageSchema.IsRead, false);
			SearchFilter finalSearchFilter = new SearchFilter.SearchFilterCollection(LogicalOperator.And, sf, readEmails);

			FindItemsResults<Item> findResults = service.findItems(WellKnownFolderName.Inbox,finalSearchFilter, view);

			for(Item item : findResults.getItems())
			{
				PropertySet itempropertyset = new PropertySet(BasePropertySet.FirstClassProperties);
				itempropertyset.setRequestedBodyType(BodyType.Text);
				view.setPropertySet(itempropertyset);
				item.load(itempropertyset);
				try {
					EmailMessage message = EmailMessage.bind(service,item.getId(),new PropertySet(BasePropertySet.FirstClassProperties, EmailMessageSchema.IsFromMe));
					EmailAddress senderName = message.getSender();
					String myData = message.getSubject();
					String meetingId= myData.replaceAll("[^0-9]", "");
					String subjectOfMeeting = item.getSubject();
					
					if(subjectOfMeeting.contains("Accepted"))
					System.out.println(senderName.toString()+" has accepted Meeting : "+meetingId);
					else if(subjectOfMeeting.contains("Tentative"))
						System.out.println(senderName.toString()+" has tentatively accepted Meeting : "+meetingId);
					else if(subjectOfMeeting.contains("Declined"))
						System.out.println(senderName.toString()+" has declined Meeting : "+meetingId);
					
					System.out.println(item.getBody());

					if(!message.getIsRead())//If message is not read..
					{
						message.setIsRead(true);
					}
					message.update(ConflictResolutionMode.AlwaysOverwrite);
				}
				catch(Exception ex)
				{
					System.out.println("Exception has come");
				}
			}

		}
		catch (Throwable e){
			e.printStackTrace();
		}
		return service;
	}
	public static void main(String[] args) {
		try {
			connectViaExchangeAutodiscover("smglegal1", "Mind@12345");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}