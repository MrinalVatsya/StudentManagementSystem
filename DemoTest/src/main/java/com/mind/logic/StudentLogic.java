/**
 * 
 */
package com.mind.logic;

import com.mind.entity.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mind.dto.*;
/**
 * @author mrinalvatsya
 *
 */
public interface StudentLogic {
		
	public List<Student> getListofStudent();
	
	public Student getStudentByRollNo(Long id);
	
	public Student addStudent(Student student);
	
	public void studentUpdate(Student student, Long rollNo);
	
	public void deleteStudentClassLogic(Long rollNo);
	
	public List<Student> ageQuery(Integer age);
	
	public Boolean exists(Long id);
	
	public Boolean existswithPredicate(String name);
	
	public Boolean existsWitheXample();
	
	public Long countExampleusingPredicate();
	
	public Long countusingExampleClass();
	
	public Long countallindb();
	
	public List<Student> findexamplewithiterableLogic();
	
	public List<Student>  findAllwithSortclassLogic();
	
	public List<Student> sortwithExampleclassLogic();
	
	public List<Student> findAllwithOrderSpecifierClassLogic();
	
	public List<Student> usingexampleclassLogic();
	
	public List<Student>  usingbasicexampleclassLogic();
	
	public StudentPage usingPageableclassLogic(Integer pageno);
	
	public StudentPage usingPageablewithSortingclassLogic(Integer pageno);
	
	public StudentPage usingPageablewithPredicateclassLogic(Integer pageno);
	
	public void deleteusingIdclassLogic(Long id);
	
	public void usingdeletewithiterableclassLogic();
	
	public void usingdeleteinbatchclassLogic();
	
	public Page<Student> findPaginatedLogicClass(Integer page, Integer size);
	
	public List<Student> getLikeExample();
	
}
