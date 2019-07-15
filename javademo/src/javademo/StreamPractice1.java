package javademo;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
public class StreamPractice1 {
	public static void main(String[] args) {
		List<String> mud = new ArrayList<>();
		mud.add("apple");
		mud.add("bear");
		mud.add("cat");
		mud.add("dog");
		mud.add("elephant");
		mud.forEach(x->System.out.println(x));//using foreach loop
		
		//using filter stream..
		List<String> l = mud.stream().filter(p->p.length()==3).map(e -> {
			System.out.print(e);
			return e;}).collect(Collectors.toList());	

	}
}
