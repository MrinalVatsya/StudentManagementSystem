/**
 * 
 */
package com.mind.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.mind.entity.StudentEntity;

/**
 * @author mrinalvatsya
 *
 */
public interface StudentDAO extends JpaRepository<StudentEntity, Long>,QuerydslPredicateExecutor<StudentEntity>,QueryByExampleExecutor<StudentEntity>{

}
