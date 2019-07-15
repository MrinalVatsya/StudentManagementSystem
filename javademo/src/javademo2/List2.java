/**
 * 
 */
package javademo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mrinalvatsya
 *
 */
public class List2 {
	public static void main(String[] args) {

		List<String> Dbcountries = new ArrayList<>();
		Dbcountries.add("Australia");
		Dbcountries.add("Brazil");
		Dbcountries.add("China");
		Dbcountries.add("Cyprus");
		Dbcountries.add("Czech Republic");
		Dbcountries.add("France");
		Dbcountries.add("Germany");
		Dbcountries.add("Hong Kong");
		Dbcountries.add("Hungary");
		Dbcountries.add("India");
		Dbcountries.add("Japan");
		Dbcountries.add("Jersey");
		Dbcountries.add("Korea, Republic Of");
		Dbcountries.add("Mexico");
		Dbcountries.add("Portugal");
		Dbcountries.add("Russian Federation");
		Dbcountries.add("Slovakia Slovak Republic");
		Dbcountries.add("South Africa");
		Dbcountries.add("Spain");
		Dbcountries.add("Sri Lanka");
		Dbcountries.add("Thailand");
		Dbcountries.add("United Arab Emirates");
		Dbcountries.add("United Kingdom");
		Dbcountries.add("United States");
		Dbcountries.add("Canada");
		Dbcountries.add("Argentina");
		Dbcountries.add("South Korea");
		Dbcountries.add("Philippines");
		Dbcountries.add("Indonesia");
		Dbcountries.add("Singapore");
		Dbcountries.add("Mauritius");
		Dbcountries.add("Macedonia");
		Dbcountries.add("Luxembourg");
		Dbcountries.add("Morocco");
		Dbcountries.add("Finland");
		Dbcountries.add("Estonia");
		Dbcountries.add("Netherlands");
		Dbcountries.add("Russia");
		Dbcountries.add("Italy");
		Dbcountries.add("Lithuania");
		Dbcountries.add("Serbia");
		Dbcountries.add("Ireland");
		Dbcountries.add("Poland");
		Dbcountries.add("Slovakia");
		Dbcountries.add("Croatia");
		System.out.println(Dbcountries.size());

		List<String> myCountries = new ArrayList<>();
		myCountries.add("Argentina");						
		myCountries.add("Australia");											
		myCountries.add("Brazil");										
		myCountries.add("Canada");										
		myCountries.add("China");										
		myCountries.add("Croatia");											
		myCountries.add("Cyprus");										
		myCountries.add("Czech Republic");										
		myCountries.add("Estonia");									
		myCountries.add("Finland");												
		myCountries.add("France");												
		myCountries.add("Germany");												
		myCountries.add("Hungary");												
		myCountries.add("India");												
		myCountries.add("Indonesia");												
		myCountries.add("Ireland");												
		myCountries.add("Italy");												
		myCountries.add("Japan");												
		myCountries.add("Korea, Republic of");												
		myCountries.add("Lithuania");												
		myCountries.add("Luxembourg");												
		myCountries.add("Macedonia, The former Yugoslav Republic of");
		myCountries.add("Mauritius");												
		myCountries.add("Mexico");												
		myCountries.add("Morocco");												
		myCountries.add("Netherlands");												
		myCountries.add("Philippines");												
		myCountries.add("Poland");												
		myCountries.add("Portugal");												
		myCountries.add("Russian Federation");
		myCountries.add("Serbia");												
		myCountries.add("Singapore");												
		myCountries.add("Slovakia");												
		myCountries.add("South Africa");												
		myCountries.add("Spain");					
		myCountries.add("Sri Lanka");									
		myCountries.add("Thailand");											
		myCountries.add("United Arab Emirates");						
		myCountries.add("United Kingdom");											
		myCountries.add("United States");	
		System.out.println(myCountries.size());
		System.out.println(Dbcountries.containsAll(myCountries));

		myCountries.removeAll(Dbcountries);
		myCountries.forEach(item->{
			System.out.println(item);
		});
	}
}
