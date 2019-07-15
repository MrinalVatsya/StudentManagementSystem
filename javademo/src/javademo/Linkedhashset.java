package javademo;
import java.util.*;
public class Linkedhashset {
	public static void main(String args[])
	{
		LinkedHashSet<String> l = new LinkedHashSet<>();
		l.add("a");
		l.add("b");
		l.add("c");
		l.add("d");
		l.add("e");
		l.add("f");
		l.add("a");//entering duplicate
		
		System.out.println(l.size());
		System.out.println("My linkedhashset contains " + l);
		 if(l.contains("a"))
			 System.out.println("yihee i found that");
		 else
			 System.out.println("oops not found sorry!!");
	}
}
