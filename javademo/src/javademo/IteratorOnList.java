package javademo;
import java.util.*;
class Students{
	int rollNo;
	String name;
	String subject;
	public Students(int rollNo, String name, String subject) {
		this.rollNo=rollNo;
		this.name=name;
		this.subject=subject;
	}
}
public class IteratorOnList {
	public static void main(String args[]) {
		LinkedList<Students> lt = new LinkedList<Students>();
		Students s1 = new Students(101,"ankit","maths");
		Students s2 = new Students(102,"mohini","science");
		Students s3 = new Students(104,"abhishek","commerce");
		     
		lt.add(s1);
		lt.add(s2);
		lt.add(s3);
		Iterator it = lt.iterator();
		while(it.hasNext())
		{
			Students stud = (Students)it.next();
			//System.out.println(stud.name);
			System.out.println(" "+stud.name.contains("mohini")) ;
/*			{
				System.out.println("found!");
			}*/
		}
	    lt.remove("mohini");
		System.out.println("List contents after removing details of mohini:");
	}
}
