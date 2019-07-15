package javademo;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

interface hello
{
	void add(Integer x , Integer y);
}
public class MapStreamPractice {
	
	class Book {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
		public static void main(String[] args) {
			
			
			Map<Integer,String> studentNameMap = new HashMap<>();
			
			studentNameMap.entrySet().stream().forEach(entry ->{
				System.out.println(entry.getKey());
				System.out.println(entry.getValue());
			});
			
			
			Optional<Entry<Integer,String>> studentOpt = studentNameMap.entrySet().stream().filter(entry -> entry.getValue().startsWith("M")).filter(maneesh -> maneesh.getKey() > 10).findFirst();
			
			if(studentOpt.isPresent()) {
				Entry<Integer,String> manu = studentOpt.get();
				System.out.println(manu.getKey());
				System.out.println(manu.getValue());
			}
			//using boolean value in filter..
			studentNameMap.entrySet().stream().filter(entry -> {
				
				if(entry.getValue().startsWith("M") && entry.getKey() > 10)
				return true;
				else return false;
			}).forEach(entry ->{
				System.out.println(entry.getKey());
				System.out.println(entry.getValue());
			});
			
			List<Book> bookList = new ArrayList<>();
			
			bookList.stream().forEach(book ->{
				book.name = "Manu";
				book.name = new String("Hello");
				System.out.println(book.getName() + book.name);
			});
			
			
			bookList.stream().map(book ->{
				
				return 0;
			}).collect(Collectors.toList());
			
			
			List<String> l = new ArrayList<>();
			l.add("MRINAL");
			l.add("VISHAL");
			l.add("HiTESH");
			//without lambda expression
			for(String s: l)
				System.out.println(s.toLowerCase());
		
			//after using lambda expression
			
			List<String> ans = l.stream().map(e->{
				System.out.println(e.toUpperCase());
				return e;
			}).collect(Collectors.toList());
			
			//without using exp.
			int x = 2, y = 3;
			hello xi = new hello()
					{
					@Override
					public void add(Integer x, Integer y){
						int sum = x+y;
						System.out.println("The Sum Is : " + sum );
					}
					};
			xi.add(x, y);
			
			//with using exp..
			hello mi = (Integer x1,Integer y1)->{
				int s = x1 + y1;
				System.out.println("The Sum Is : " + s);};
			mi.add(x, y);
		}
}
