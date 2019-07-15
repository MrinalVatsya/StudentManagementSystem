package javademo;//Demo of hashset
import java.util.*;
public class HashSetPractice {
 public static void main(String args[]) {
	HashSet<String> h = new HashSet<String>();
	h.add("mrinal");
	h.add("is");
	h.add("member");
	h.add("of");
	h.add("legal1");
	h.add("team");
	h.add("team");
	h.add("NULL");//maximum 1 null element allowed in hashset..
	h.add("NULL");
	System.out.println("Contents of hash set : " + h);//set donot contain duplicate elements.
	
	//whether hash contains an element or not
	Boolean x = h.contains("mrinal");
	if(x==true)
	System.out.println("set contains element");
	else
	System.out.println("Set donot contain element");
	System.out.println();
	Iterator<String> i = h.iterator();
	while(i.hasNext())
		System.out.println(i.next());
}
}
