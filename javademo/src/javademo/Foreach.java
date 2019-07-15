package javademo;

import java.util.*;

public class Foreach {
	public static void main(String[] args) {
   List<Integer> num = Arrays.asList(1,2,3,4);
  //using map stream
   num.stream().map(x->x*2).forEach(System.out::println);
   
}
}