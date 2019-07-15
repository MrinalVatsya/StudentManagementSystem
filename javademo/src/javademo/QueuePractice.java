package javademo;//Demo of queue..

import java.util.*;

public class QueuePractice {
	public static void main(String args[])
	{
	Queue<Integer> q = new LinkedList<Integer>();
	for(int i = 0; i< 4;i++)//adding elements to queue
	{
		q.add(i+1);
	}
		System.out.print("My Queue contains : "+q);
		
		int x = q.remove();//GET top element from array
		System.out.println();
		System.out.println("Removed Element is : "+ x);
		//calculating sum of array using queue
		int sum = 0;
		while(q.size()>0)
		{
			int y = q.remove();
			sum += y;
			//System.out.println(q.size());
		}
		System.out.println(sum);
	}
}