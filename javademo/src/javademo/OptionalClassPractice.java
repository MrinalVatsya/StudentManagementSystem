package javademo;
import java.util.*;
public class OptionalClassPractice {
	public static void main(String[] args) {
	String[] str = new String[10];
	
	//using optional class to handle null pointer exception..
	Optional<String> x = Optional.ofNullable(str[2]);
	if(x.isPresent())//to check value is present or not.
	{
		System.out.println("something is there");
	}
	else
		System.out.println("nothing is here");
	}
}
