/**
 * 
 */
package com.mind.entity;

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
@Table(name="ApplicationUser")
//@SequenceGenerator(name="Seq_Student_RollNo", initialValue =500, allocationSize=1, sequenceName = "Seq_Student_RollNo")
public class ApplicationUser {
	
    @Id
    private long id;
    private String username;
    private String password;
    public long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}