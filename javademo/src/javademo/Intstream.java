package javademo;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Intstream {
  public static void main(String[] args) {
	 List<Integer> s = IntStream.range(1,5).mapToObj(i->i*2).map(m->{
		 System.out.println(m);
		 return m;
	 }).collect(Collectors.toList());//using IntStream..
	  System.out.println(s);
	  
	  List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);//using reduce function
	  
      // Finding sum of all elements
      int sum = array.stream().reduce(0, (x,y)->(x+y));

      // Displaying sum of all elements
      System.out.println("The sum of all elements is " + sum);
 }
}
