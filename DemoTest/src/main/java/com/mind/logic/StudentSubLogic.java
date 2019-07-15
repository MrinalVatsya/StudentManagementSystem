/**
 * 
 */
package com.mind.logic;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mind.dto.Student;
import com.mind.entity.StudentEntity;
import com.mind.entity.StudentMarksEntity;

/**
 * @author mrinalvatsya
 *
 */
@Service
public interface StudentSubLogic {

	
	public List<StudentEntity> getStudent_List();//get all student list from database.
	
	public Optional<StudentEntity> getStudentByid(Long id);
	
	public Long addStudentSubLogic(StudentEntity entity);
	
	public Long createStudentMarks(StudentMarksEntity marksentity);/////////
	
	public void deleteFromStudentMarksTable(Long id);
	
	public void deleteStudentClassSubLogic(Long id);
	
	public void deleteStudentClassSubLogic(StudentMarksEntity marksentity) ;
	
	public Iterable<StudentEntity> ageQuerySubLogic(Integer age);
	
	public Boolean existsSubLogic(Long id);
	
	public Boolean existswithPredicateSubLogic(String name);
	
	public Boolean existsWithExampleSubLogic();
	
	public Long countwithPredicateSubLogic();
	
	public Long countwithexampleclassSubLogic();
	
	public Long countallindbSubLogic();
	
	public Iterable<StudentEntity> findexamplewithiterableSubLogic();
	
	public List<StudentEntity>  findAllwithSortclassSubLogic();
	
	public List<StudentEntity> sortwitsortwithExampleclassSubLogic();
	
	public Iterable<StudentEntity> findAllwithOrderSpecifierClassSubLogic();
	
	public List<StudentEntity> usingexampleclassSubLogic();
	
	public List<StudentEntity>  usingbasicexampleclassSubLogic();
	
	public Page<StudentEntity> usingPageableclassSubLogic(Integer pageNo);
	
	public Page<StudentEntity> usingPageableclasswithSortclassSubLogic(Integer pageno);
	
	public Page<StudentEntity> usingPageablewithPredicateclassSubLogic(Integer pageno);
	
	public void deleteusingIdclassSubLogic(Long id);
	
	public void deleteusingEntityclassSubLogic(StudentEntity entity);
	
	public void usingDeleteWithIterableClassSubLogic();
	
	public void usingdeleteinbatchclassLogicSubLogic();
	
	public Page<StudentEntity> findPaginatedSubLogicClass(Integer page, Integer size);/***************/
	
	public List<StudentEntity> getLikeExampleEntity();

}
