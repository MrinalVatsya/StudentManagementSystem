/**
 * 
 */
package com.mind.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author mrinalvatsya
 *
 */
@Entity
@Table(name="StudentMarks")
@SequenceGenerator(name="Seq_StudentMarks_Id", initialValue =500, allocationSize=1, sequenceName = "Seq_StudentMarks_Id")
public class StudentMarksEntity implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -1810055156212649246L;

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Seq_StudentMarks_Id")
	private Long id;
	
	@Column(name = "RoleNo")
	private Long rollNo;
	
	@Column(name = "SubjectName")
	private String subjectname;
	
	@Column(name = "Marks")
	private Integer marks;
	
	public String getSubjectname() {
		return subjectname;
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
	 * @param subjectname the subjectname to set
	 */
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

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
