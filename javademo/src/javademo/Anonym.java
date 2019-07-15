package javademo;
import java.util.*;
public class Anonym {
	public static void main(String[] args) {
		//creating thread without using lambda expression
		
		new Thread(new Runnable() //anonymous class..
		{
			public void run()
			{
				System.out.println("Thread1 Created");
			}
		}).start();
		
		//creating thread with lambda expression
		Runnable task2 = ()->System.out.println("thread2 created");
		new Thread(task2).start();
	}
}
