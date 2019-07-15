package javademo2;//using streams in java..

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Book
{
	String name;
	Set<String>book;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	 public void addBook(String book) {
	        if (this.book == null) {
	            this.book = new HashSet<>();
	        }
	        this.book.add(book);
	    }
	/**
	 * @return the book
	 */
	public Set<String> getBook() {
		return book;
	}
	/**
	 * @param book the book to set
	 */
	public void setBook(Set<String> book) {
		this.book = book;
	}
}
//stream can be operated only once 
public class FlatMapPractice {
			public static void main(String[] args) {
				Book obj1 = new Book();
			        obj1.setName("mkyong");
			        obj1.addBook("Java 8 in Action");
			        obj1.addBook("Spring Boot in Action");
			        obj1.addBook("Effective Java (2nd Edition)");

			    	Book obj2 = new 	Book();
			        obj2.setName("zilap");
			        obj2.addBook("Learning Python, 5th Edition");
			        obj2.addBook("Effective Java (2nd Edition)");

			        List<Book> list = new ArrayList<>();
			        list.add(obj1);
			        list.add(obj2);
			        
			        List<String> booklist = list.stream().map(book->book.getBook()).flatMap(hit->hit.stream()).collect(Collectors.toList());
			        booklist.forEach(x->System.out.println(x));
			        
			        
			       // Stream<int[]> steam = Stream.of(array); 
				      /*  List<Integer> result = steam.collect(Collectors.toList());
				        System.out.println(result);*/
				        
				        Stream<List<String>> namesOriginalList = Stream.of(
				        		Arrays.asList("Pankaj"), 
				        		Arrays.asList("David", "Lisa"),
				        		Arrays.asList("Amit"));
				        	//flat the stream from List<String> to String stream
				        List<String> ans = namesOriginalList.flatMap(x->x.stream()).collect(Collectors.toList());
//				        	Stream<String> flatStream = namesOriginalList
//				        		.flatMap(strList -> strList.stream());

				        	//flatStream.forEach(System.out::println);
				        	ans.forEach(System.out::println);
				        	int[] intArray = {1, 2, 3, 4, 5, 6};

				            //1. Stream<int[]>
				            Stream<int[]> streamArray = Stream.of(intArray);

				            //2. Stream<int[]> -> flatMap -> IntStream
				           
				            IntStream result1 = streamArray.flatMapToInt(gut->Arrays.stream(gut));
				            
				            	result1.forEach(x->System.out.println(x));
				           // intStream.forEach(x -> System.out.println(x));
				            	
				            	
				            OptionalInt sum = Arrays.stream(intArray).reduce((x,y)->x+y);

				            if(sum.isPresent())
				            	System.out.println(sum.getAsInt());
				            else
				            	System.out.println("null");
				}
			}
