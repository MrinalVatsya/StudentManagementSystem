 /**
 * 
 */
package com.mind.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * @author mrinalvatsya
 *
 */
@Entity
@Table(name="Student")
@SequenceGenerator(name="Seq_Student_RollNo", initialValue =500, allocationSize=1, sequenceName = "Seq_Student_RollNo")
public class StudentEntity implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6942178221404869393L;


	@Id
	@Column(name = "RoleNo")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Seq_Student_RollNo")
	private Long id;
	

	@OneToMany
	@JoinColumn(name = "RoleNo", referencedColumnName="RoleNo")
	private List<StudentMarksEntity> subjectmarkslist;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Age")
	private Integer age;

	/**
	 * @return the roleNo
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param roleNo the roleNo to set
	 */
	public void setId(Long id) {
		this.id = id;
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

	/**
	 * @return the subjectmarkslist
	 */
	public List<StudentMarksEntity> getSubjectmarkslist() {
		return subjectmarkslist;
	}

	/**
	 * @param subjectmarkslist the subjectmarkslist to set
	 */
	
	public void setSubjectmarkslist(List<StudentMarksEntity> subjectmarkslist) {
		this.subjectmarkslist = subjectmarkslist;
	}
}
