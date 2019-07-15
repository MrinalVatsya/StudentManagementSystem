/**
 * 
 */
package com.mind.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mrinalvatsya
 *
 */
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8182069299081106743L;
	private String name;
	private Long rollNo;
	private Integer age;
	
	private List<StudentMarks> subjectmarkslist = new ArrayList<>();
	
	
	public Student() {
		super();
	}
	/**
	 * @return the subjectmarkslist
	 */
	public List<StudentMarks> getSubjectmarkslist() {
		return subjectmarkslist;
	}
	/**
	 * @param subjectmarkslist the subjectmarkslist to set
	 */
	public void setSubjectmarkslist(List<StudentMarks> subjectmarkslist) {
		this.subjectmarkslist = subjectmarkslist;
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
	 * @return the rollNo
	 */
	public Long getRollNo() {
		return rollNo;
	}

	/**
	 * @param rollNo the rollNo to set
	 */
	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
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

	public Student(String name, Long rollNo, Integer age) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.age = age;
	}
	}
