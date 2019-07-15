/**
 * 
 */
package javademo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mrinalvatsya
 *
 */
public class UncommonListPOC {
	public static void main(String[] args) {
	List<Integer> list1 = new ArrayList<>();
	list1.add(1);
	list1.add(2);
	list1.add(3);
	list1.add(4);
	list1.add(5);
	List<Integer> list2 = 	new ArrayList<>();
	list2.add(2);
	list2.add(3);
	list2.add(7);

	list2.removeAll(list1);
	list2.forEach(item->{
		System.out.println(item);
	});
	
	List<Integer> split = Arrays.asList(1,2,10);
	List<Integer> list = new LinkedList<Integer>();
	list.removeAll(list1);
	list.forEach(item->{
		System.out.println(item);
	});
	}
}
