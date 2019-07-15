package com.mind.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.mind.entity.StudentEntity;

public interface StudentDAO extends JpaRepository<StudentEntity, Long>,QuerydslPredicateExecutor<StudentEntity>{

}
