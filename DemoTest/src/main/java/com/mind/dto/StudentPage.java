package com.mind.dto;

import java.io.Serializable;
import java.util.List;

public class StudentPage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6441558144357767164L;
	
	private Integer currentPageNo ;
	private Integer totalpages ;
	 
	private List<Student> studentlist ;

	/**
	 * @return the currentPageNo
	 */
	public Integer getCurrentPageNo() {
		return currentPageNo;
	}

	/**
	 * @param currentPageNo the currentPageNo to set
	 */
	public void setCurrentPageNo(Integer currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	/**
	 * @return the totalpages
	 */
	public Integer getTotalpages() {
		return totalpages;
	}

	/**
	 * @param totalpages the totalpages to set
	 */
	public void setTotalpages(Integer totalpages) {
		this.totalpages = totalpages;
	}

	/**
	 * @return the studentlist
	 */
	public List<Student> getStudentlist() {
		return studentlist;
	}

	/**
	 * @param studentlist the studentlist to set
	 */
	public void setStudentlist(List<Student> studentlist) {
		this.studentlist = studentlist;
	}
}
