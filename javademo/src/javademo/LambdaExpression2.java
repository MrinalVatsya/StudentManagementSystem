package javademo;
import java.util.*;
interface poll
{
	void details(String name); 
}
public class LambdaExpression2 {
	public static void main(String[] args) {
		String a = "legal1";
		poll p = new poll() {
			
			//without lambda expression
			public void details(String name)
			{
				System.out.println("Hello " + name);
			}
		};
		p.details(a);
		
		//using lambda expression passing one parameter
		poll x = (String name)->System.out.println("Hello san " + name);
		x.details(a);
	}
}
