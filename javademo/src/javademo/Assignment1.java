package javademo;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.RowFilter.ComparisonType;
class Subject
{
	String name;
	Integer actual_marks;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getActual_marks() {
		return actual_marks;
	}
	public void setActual_marks(Integer actual_marks) {
		this.actual_marks = actual_marks;
	}
	Subject(String name, Integer actual_marks)
	{
		this.name = name;
		this.actual_marks = actual_marks;
	}
}
class Student
{
	Integer rollno;
	String name;
	Integer age;
	public Integer getRollno() {
		return rollno;
	}
	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}
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
	public List<Subject> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	List<Subject> subjectList = new ArrayList<>();
	Student(Integer rollno, String name, Integer age)
	{
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
}
/*class sortx implements Comparator<Student>
{
	public int compare(Student a, Student b)
    {
        //return a.subjectList.actual_marks.compareTo(b.subjectList.actual_marks);
        if(a.subjectList.get(0).actual_marks==b.subjectList.get(0).actual_marks)  
        	return 0;  
        	else if(a.subjectList.get(0).actual_marks>a.subjectList.get(0).actual_marks)  
        	return 1;  
        	else  
        	return -1;  
    }
}*/
class func
{
public void get_Details(Integer Age, String Subject_Name, List<Student> a1)
{
	List<Integer> resultset = new ArrayList<>();
	int i, j,x = 0;
	Map<Integer,Integer> ko = new HashMap<>();
	  for(i = 0;i < a1.size();i++)
	  {
		  for(j=0;j<a1.get(i).subjectList.size();j++)
		  {
			  if(a1.get(i).subjectList.get(j).name.equals(Subject_Name)&&a1.get(i).age >= Age )
			  {
				  //System.out.println(a1.get(i).subjectList.get(j).actual_marks);
				  resultset.add(a1.get(i).subjectList.get(j).actual_marks);
				  ko.put(i,a1.get(i).subjectList.get(j).actual_marks);
			  }
		  }
	  }
	  
		  Iterator it = resultset.iterator();
			Integer max = 0, local = 0;
			Set keys = new HashSet<>();
			while(it.hasNext())
			{
				i = (Integer)it.next();
				if(i>max)
				{
					max = i;
				}
			}
			for(Map.Entry<Integer, Integer> entry : ko.entrySet())
			{
				if(max.equals(entry.getValue()))
				{
					keys.add(entry.getKey());
					local = entry.getKey();
				}
			}
			//System.out.println(keys.size());
			Iterator it1 = keys.iterator();
			while(it1.hasNext())
			{
				i = (Integer)it1.next();
				System.out.println(" Student Name :  " + a1.get(i).name);	
			}
	  
}
}
public class Assignment1 {	
  public static void main(String[] args) {
	  List<Student> a1 = new ArrayList<>();
	  	func obj = new func();
	   /* Integer rollNo = 1;
	  	String name = "sai";
	  	Integer age = 21;
	  	Map<String,Integer> subjectMarks = new HashMap<>();
	  	subjectMarks.put("hindi",25);
	  	
	  	
	  	
	  	addStudent(rollNo,name,age,subjectMarks,a1);*/
	  	
	  	a1.add(new Student(1,"sai",21));
	  	a1.add(new Student(2,"amit",24));
	  	a1.add(new Student(3,"navanshu",25));
	  	a1.add(new Student(4,"ninja",22));
	  	a1.add(new Student(5,"rakesh",21));
	  	a1.add(new Student(6,"rishabh",20));
	  	a1.add(new Student(7,"atul",23));
	  	a1.add(new Student(8,"pavan",28));
	  	a1.add(new Student(9,"nitin",29));
	  	a1.add(new Student(10,"deepak",21));
	 // 	System.out.println(a1.get(0).name);
	  	
	  	 	
	  		a1.get(0).subjectList.add(new Subject("hindi",25));
	  		a1.get(0).subjectList.add(new Subject("english",50));
	  		a1.get(0).subjectList.add(new Subject("maths",80));
	  		a1.get(0).subjectList.add(new Subject("physics",90));
	  		a1.get(0).subjectList.add(new Subject("chemistry",75));
	  		
	  		
	  		a1.get(1).subjectList.add(new Subject("hindi",26));
	  		a1.get(1).subjectList.add(new Subject("english",51));
	  		a1.get(1).subjectList.add(new Subject("maths",82));
	  		a1.get(1).subjectList.add(new Subject("physics",50));
	  		a1.get(1).subjectList.add(new Subject("chemistry",20));
	  		//System.out.println(a1.get(1).subjectList.get(2).actual_marks);
	  		
	  		a1.get(2).subjectList.add(new Subject("hindi",27));
	  		a1.get(2).subjectList.add(new Subject("english",52));
	  		a1.get(2).subjectList.add(new Subject("maths",99));
	  		a1.get(2).subjectList.add(new Subject("physics",51));
	  		a1.get(2).subjectList.add(new Subject("chemistry",56));
	  		
	  		a1.get(3).subjectList.add(new Subject("hindi",28));
	  		a1.get(3).subjectList.add(new Subject("english",53));
	  		a1.get(3).subjectList.add(new Subject("maths",84));
	  		a1.get(3).subjectList.add(new Subject("physics",55));
	  		a1.get(3).subjectList.add(new Subject("chemistry",75));
	  		
	  		a1.get(4).subjectList.add(new Subject("hindi",28));
	  		a1.get(4).subjectList.add(new Subject("english",55));
	  		a1.get(4).subjectList.add(new Subject("maths",86));
	  		a1.get(4).subjectList.add(new Subject("physics",65));
	  		a1.get(4).subjectList.add(new Subject("chemistry",79));
	  		
	  		a1.get(5).subjectList.add(new Subject("hindi",29));
	  		a1.get(5).subjectList.add(new Subject("english",78));
	  		a1.get(5).subjectList.add(new Subject("maths",85));
	  		a1.get(5).subjectList.add(new Subject("physics",65));
	  		a1.get(5).subjectList.add(new Subject("chemistry",72));
	  		
	  		a1.get(6).subjectList.add(new Subject("hindi",45));
	  		a1.get(6).subjectList.add(new Subject("english",65));
	  		a1.get(6).subjectList.add(new Subject("maths",79));
	  		a1.get(6).subjectList.add(new Subject("physics",87));
	  		a1.get(6).subjectList.add(new Subject("chemistry",75));
	  		
	  		a1.get(7).subjectList.add(new Subject("hindi",19));
	  		a1.get(7).subjectList.add(new Subject("english",20));
	  		a1.get(7).subjectList.add(new Subject("maths",52));
	  		a1.get(7).subjectList.add(new Subject("physics",45));
	  		a1.get(7).subjectList.add(new Subject("chemistry",56));
	  		
	  		a1.get(8).subjectList.add(new Subject("hindi",42));
	  		a1.get(8).subjectList.add(new Subject("english",95));
	  		a1.get(8).subjectList.add(new Subject("maths",99));
	  		a1.get(8).subjectList.add(new Subject("physics",75));
	  		a1.get(8).subjectList.add(new Subject("chemistry",66));
	  		
	  		a1.get(9).subjectList.add(new Subject("hindi",12));
	  		a1.get(9).subjectList.add(new Subject("english",13));
	  		a1.get(9).subjectList.add(new Subject("maths",45));
	  		a1.get(9).subjectList.add(new Subject("physics",65));
	  		a1.get(9).subjectList.add(new Subject("chemistry",59));
	  		
	  Map<String,Integer> m = new HashMap<>();
		m.put("maths",100);
		m.put("english",100);
		m.put("hindi", 50);
		m.put("physics", 90);
		m.put("chemistry", 80);
		
		Map<String,String> n = new HashMap<>();
		n.put("maths", "mrinal");
		n.put("english", "vishal");
		n.put("hindi", "hitesh");
		n.put("physics", "kunal");
		n.put("chemistry", "rahul");
		
//		 Optional<Student> maxMarks = 
//		            a1.stream().filter(p->p.getSubjectList().get(0).getName().equals("physics"))
//		            .collect(Collectors.maxBy(Comparator.comparing(x->x.getSubjectList().get(0).getActual_marks())));
//		 System.out.println(maxMarks.isPresent()? maxMarks.get().name:"Not Applicable");
//		
		
		 /*Optional<Student> maxMarks = 
		            a1.stream().collect(Collectors.maxBy(Comparator.comparing(x->x.getSubjectList().get(0).getActual_marks())));
		 System.out.println(maxMarks.isPresent()? maxMarks.get().name:"Not Applicable");*/
		
		
		/*  Optional<Student> maxSalaryEmp = 
		            a1.stream()
		            .collect(Collectors.groupingBy(x->x.getSubjectList().get(0).getName(),
		            		maxBy(Comparator.comparingInt(y->y.getSubjectList().get(0).getActual_marks()))));*/
		  	
	//	System.out.println(a1.get(0).subjectList.size());
		  int i,j,x;
		  List<Integer> cu = new ArrayList<>();
		  List<String> su = new ArrayList(m.keySet());//Arrays.asList("maths","physics","english","hindi","chemistry");
		
		  
		  Map<String,Integer> mo = new HashMap<>();
		 
		  for(x = 0; x < su.size();x++)
		  {
		  for(i = 0;i < a1.size();i++)
		  {
			  for(j=0;j<a1.get(i).subjectList.size();j++)
			  {
				  if(a1.get(i).subjectList.get(j).name.equals(su.get(x)))
				  {
					 //System.out.println(a1.get(i).subjectList.get(j).actual_marks);
					cu.add(a1.get(i).subjectList.get(j).actual_marks);
				  }
			  }
		  }
		  Iterator it = cu.iterator();
			int max = 0, total = 0; 
			while(it.hasNext())
			{
				i = (Integer)it.next();
				total += i;
				if(i>max)
					max = i;
			} 
			float avg = total/a1.size();
			int index = cu.indexOf(max);
			mo.put(su.get(x),max);
			 String teacher_name = n.get(su.get(x));
			 System.out.print("Teacher : " + teacher_name);
			 for (Map.Entry<String,Integer> entry : mo.entrySet()) 
		            System.out.print("     Subject = " + entry.getKey()  +
		                             "         Max_Marks = " + entry.getValue());
			 System.out.print("           Student Name :  " + a1.get(index).name);
			 System.out.println("           Average Marks = " + avg);
			 mo.clear();
			 cu.clear();
			 }	  
		  obj.get_Details(24, "maths", a1);
}
}
