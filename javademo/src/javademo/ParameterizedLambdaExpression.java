package javademo;
import java.util.*;
interface fun
{
	int Square(int x);
}
public class ParameterizedLambdaExpression {
	public static void main(String[] args) {
		    int a = 5;
		    //without using lambda expression
		    fun f = new fun()
		    		{
		    			public int Square(int x)
		    			{
		    				return x*x;
		    			}
		    		};
		    		f.Square(a);
			fun g = (int x)->x*x;
			int ans = g.Square(a);
			System.out.println(ans);
	}
}

