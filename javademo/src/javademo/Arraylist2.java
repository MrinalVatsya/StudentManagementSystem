package javademo;//Demo of List and LinkedList.. 
import java.util.*;
public class Arraylist2 {
	public static void main(String args[])
	{
	/*int[] arr = new int[4];
	for(int i = 0;i< 4;i++)
		arr[i] = i+1;
	for(Integer x : arr)//New for loop in java
		System.out.print(x+" ");*/
		int i;
		List<String> m = new ArrayList<String>(5);
		m.add("mrinal");
		m.add("legal1");
		m.add("team");
		//searching in list
		
			//System.out.println("First Occurence of text is : "+ m.indexOf("mrinal"));
			
			//creating linked list in java
			LinkedList<Character> l = new LinkedList<Character>();
			l.add('a');
			l.add('b');
			l.add('c');
			l.add('d');
			l.add('e');
			
			System.out.println("My Linked List is : "+ l);
			/*l.remove(0); using remove methods
			 * 
			System.out.println("After Deletion My Linked List is : "+ l);*/
			
			boolean p = l.contains('a');//check whether element is present or not.
			System.out.println(p);
			
			//using get and set methods..
			Character c = l.get(2);
			System.out.println(c);
			l.set(2, 'h');
			System.out.println("After Updation My Linked List is : "+ l);
			
			//Study diffrence between arraylist and vector
	}
}
