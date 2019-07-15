package com.mind.entity;

/**
 * 
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * @author mrinalvatsya
 *
 */
@Entity
@Table(name="Student")
public class StudentEntity implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3706235696831161869L;


	@Id
	@Column(name = "RoleNo")
	private Long roleNo;
	
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Age")
	private Integer age;

	/**
	 * @return the roleNo
	 */
	public Long getRoleNo() {
		return roleNo;
	}

	/**
	 * @param roleNo the roleNo to set
	 */
	public void setRoleNo(Long roleNo) {
		this.roleNo = roleNo;
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
