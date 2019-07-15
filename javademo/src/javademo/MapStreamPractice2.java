package javademo;
import java.util.*;
import java.util.stream.Collectors;
public class MapStreamPractice2 {
 public static void main(String[] args) {
	       List<String> users = Arrays.asList("mrinal","hitesh","ram","shyam","gyan");
	       List<String> s = users.stream().filter(x->x.equals("minal")).map(e->{
	    	   System.out.println(e);
	    	   return e;
	       }).collect( Collectors.toList());
 }
}
