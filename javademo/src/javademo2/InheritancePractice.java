package javademo2;
import java.util.*;
class abc
{
	private Integer x;

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}
}
public class InheritancePractice extends abc{
	public static void main(String[] args) {
		InheritancePractice obj = new InheritancePractice();
		obj.setX(4);
		System.out.println(obj.getX());
	}
}
