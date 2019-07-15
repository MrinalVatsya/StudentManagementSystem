/**
 * 
 */
package com.mind.dto;

import java.io.Serializable;

/**
 * @author mrinalvatsya
 *
 */
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2959111729980461164L;

	private Long roleNo;
	
	private String name;
	
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

	private Integer age;
}
