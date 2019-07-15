/**
 * 
 */
package com.mind.dto;

import java.io.Serializable;

/**
 * @author mrinalvatsya
 *
 */
public class StudentMarks implements Serializable{

	private static final long serialVersionUID = -8269089704980195250L;
	private Long id;
	private String subjectname;
	private Integer marks;
	
	/**
	 * @return the subjectname
	 */
	public String getSubjectname() {
		return subjectname;
	}
	/**
	 * @param subjectname the subjectname to set
	 */
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	/**
	 * 
	 */
	/**
	 * @return the name
	 */
	
	/**
	 * @return the marks
	 */
	public Integer getMarks() {
		return marks;
	}
	/**
	 * @param marks the marks to set
	 */
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	/**
	 * @return the subjectid
	 */
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
