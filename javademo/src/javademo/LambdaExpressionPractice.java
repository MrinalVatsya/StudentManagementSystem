package javademo;
import java.util.*;
interface green
{
	void show();
}
public class LambdaExpressionPractice {
	public static void main(String[] args) {
		
		/*green g = new green()//without lambda expression
			{
			public void show()
			{
				System.out.println("my name is mrinal");
			}
			};
			g.show();*/
			
			//using lambda expression
			green g = ()->System.out.println("my name is mrinal");
			g.show();
	}
}
