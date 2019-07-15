package javademo2;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.*;
class Student
{
    String name;
    Integer age;
    public Student(String name,Integer age)
    {
        this.name = name;
        this.age  = age;
    }
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
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
}
public class Practice{

    public static void main(String[] args) {
      List<Student> l = new ArrayList<>();
      l.add(new Student("mrinal",1));
      l.add(new Student("Vishal",2));
      List<Student> lo = l.stream().filter(y->y.getAge().equals(2)).map(e->{System.out.println(e.getName());
		return e;
		}).collect(Collectors.toList());
    }
}