package javademo;
import java.util.*;
import java.util.Map.Entry;
public class Treemap {
	public static void main(String[] args) {
		TreeMap<Integer, String> t = new TreeMap<Integer, String>();
		t.put(21, "mrinal");
		t.put(18, "vishal");
		t.put(15, "vimal");
		t.put(2, "kushal");
		t.put(50, "sambhal");
	 
		Set s = t.entrySet();
		Iterator it = s.iterator();
		while(it.hasNext())
		{
			Entry ne = (Entry) it.next();
			System.out.println(ne.getKey()+" " + ne.getValue());
		}
		for(Map.Entry<Integer, String> entry : t.entrySet())
		 System.out.println("key is : " +entry.getKey() + "  value is : "+entry.getValue());
	 }
}
