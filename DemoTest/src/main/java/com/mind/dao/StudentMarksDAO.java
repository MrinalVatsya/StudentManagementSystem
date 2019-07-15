package com.mind.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;


import com.mind.entity.StudentMarksEntity;

public interface StudentMarksDAO extends JpaRepository<StudentMarksEntity, Long>,QuerydslPredicateExecutor<StudentMarksEntity>,QueryByExampleExecutor<StudentMarksEntity>{

}
