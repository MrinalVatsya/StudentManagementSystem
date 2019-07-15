package javademo2;
import java.util.*;//using group by with maxBy function..
import java.util.stream.Collectors;
class fun
{
	String name;
	Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public fun(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
}

public class MaxByfunction {
	public static void main(String[] args) {
			 List<fun> list = new ArrayList<>();
			 list.add(new fun("mrinal",80));
			 list.add(new fun("mrinal",22));
			 list.add(new fun("kunal", 12));
			
			Optional<fun>result =  list.stream().collect(Collectors.maxBy(Comparator.comparing(x->x.getAge())));
			 Map<Object, Optional<fun>> map = list.stream()
					 .collect(Collectors.groupingBy(x->x.getName(),Collectors.maxBy(Comparator.comparing(y->y.getAge()))));
			if(result.isPresent())
				System.out.println(result.get().getName());
			else
				System.out.println("oops failed again!!");
			for(Map.Entry<Object, Optional<fun>> entry : map.entrySet())
			{
				System.out.println("Name is : " +  entry.getKey() + " Age is : " +entry.getValue().get().getAge());
			}
	}
}
