/**
 * 
 */
package com.mind.logic.impl;

import com.mind.logic.StudentLogic;
import com.mind.logic.StudentSubLogic;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.mind.dao.StudentDAO;
import com.mind.dto.Student;
import com.mind.dto.StudentMarks;
import com.mind.dto.StudentPage;
import com.mind.entity.*;

/**
 * @author mrinalvatsya
 *
 */
@Service
@Transactional
public class StudentLogicImpl implements StudentLogic{
	
	@Autowired
	StudentSubLogic studentsubLogicObject;
	
	 private final static Logger LOGGER = 
	            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Override
	public List<Student> getListofStudent() {
		// call sub logic
		
		List<StudentEntity> studentlist = studentsubLogicObject.getStudent_List();
		
		List<Student> result = studentlist.stream().map(entity ->{
			
			return updateStudentData(entity);
		}).collect(Collectors.toList());
		 

		return result;
	}
	
	
	private Student updateStudentData(StudentEntity entity) {//common function..
		Student student = new Student();
		
		student.setRollNo(entity.getId());
		student.setName(entity.getName());
		student.setAge(entity.getAge());
		
		if(entity.getSubjectmarkslist() != null && entity.getSubjectmarkslist().size() > 0) {
			List<StudentMarks> marks = entity.getSubjectmarkslist().stream().map(marksEntity ->{
				StudentMarks studentMarks = new StudentMarks();
				studentMarks.setSubjectname(marksEntity.getSubjectname());
				studentMarks.setMarks(marksEntity.getMarks());
				studentMarks.setId(marksEntity.getId());
				return studentMarks;
			}).collect(Collectors.toList());
			
			student.setSubjectmarkslist(marks);
		}
		
		return student;
		
	}


	@Override
	public Student getStudentByRollNo(Long id) {
	
		//call method of sub logic layer..
		Optional<StudentEntity> studentEntryOpt = studentsubLogicObject.getStudentByid(id);
		if(studentEntryOpt.isPresent())
		{
			StudentEntity entity = studentEntryOpt.get();
			LOGGER.log(Level.INFO, "Student Details of : "+entity.getName());
			return updateStudentData(entity);
		}
		else
		{
			LOGGER.log(Level.INFO, "No student exists");
			return null;
		}
	}
	
	@Override
	public Student addStudent(Student student) {
		StudentEntity entity = new StudentEntity();
		//entity.setId(student.getRollNo());
		entity.setName(student.getName());
		entity.setAge(student.getAge());
		
		Long id = studentsubLogicObject.addStudentSubLogic(entity);
		student.setRollNo(id);
		if(student.getSubjectmarkslist() != null && student.getSubjectmarkslist().size() > 0) {
			student.getSubjectmarkslist().stream().forEach(subject ->{
				StudentMarksEntity obj = new StudentMarksEntity();
				obj.setRollNo(id);
				obj.setMarks(subject.getMarks());
				obj.setSubjectname(subject.getSubjectname());
				Long marksId = studentsubLogicObject.createStudentMarks(obj);	
				subject.setId(marksId);
			});
		}		
		return  student; //for changing the dto for sending.. 
	}
	
	@Override
	public void studentUpdate(Student student, Long rollNo) {
		Optional<StudentEntity> studentEntryOpt = studentsubLogicObject.getStudentByid(rollNo);
		
		List<Long> idlist = new ArrayList<>();//list containing all ids..
	
		if(studentEntryOpt.isPresent())//then it is case of update
		{
			StudentEntity entity = studentEntryOpt.get();
			LOGGER.log(Level.INFO, "Student whose details is updated is : "+entity.getName());
			entity.setName(student.getName());
			entity.setAge(student.getAge());
			LOGGER.log(Level.INFO, "After updation : "+entity.getName());
			
			//list containing all ids in database..
			entity.getSubjectmarkslist().stream().map(mapper->{
				idlist.add(mapper.getId());
				return mapper;
			}).collect(Collectors.toList());
			
			if(student.getSubjectmarkslist() != null && student.getSubjectmarkslist().size() > 0)
			{
					student.getSubjectmarkslist().stream().forEach(subject->{
						if(subject.getId()==null)//create new subject..
						{
							StudentMarksEntity newentity = new StudentMarksEntity();
							newentity.setSubjectname(subject.getSubjectname());
							newentity.setMarks(subject.getMarks());
							newentity.setRollNo(rollNo);
							studentsubLogicObject.createStudentMarks(newentity);
							entity.getSubjectmarkslist().add(newentity);
						}
						else//case of update..
						{
							Long markstableid = subject.getId();
							entity.getSubjectmarkslist().stream().filter(predicate->predicate.getId()==markstableid).forEach(marks->{
								marks.setMarks(subject.getMarks());
								marks.setSubjectname(subject.getSubjectname());
								idlist.remove(markstableid);
							});
						}
					});
			}
			idlist.forEach(deleteid->{
				studentsubLogicObject.deleteFromStudentMarksTable(deleteid);
			});
		}
	}
	
	@Override
	public void deleteStudentClassLogic(Long rollNo) {
			Optional<StudentEntity>  studentEntryOpt = studentsubLogicObject.getStudentByid(rollNo);
			if(studentEntryOpt.isPresent())
			{
				StudentEntity studententity = studentEntryOpt.get();
			/*	if(studententity.getSubjectmarkslist() != null && studententity.getSubjectmarkslist().size() > 0)
				{
					studententity.getSubjectmarkslist().stream().forEach(subject->
					{
						Long deleteid = subject.getId();
						studentsubLogicObject.deleteStudentClassSubLogic(subject);//delete from studentmarks table..
					
					});
				}
				*/
				studentsubLogicObject.deleteusingEntityclassSubLogic(studententity);//delete from student table..
			}
			else
			{
				System.out.println("Student cannot be deleted");
			}
	}
	
	@Override
	public List<Student> ageQuery(Integer age) {
		
		Iterable<StudentEntity>  studentEntityIt = studentsubLogicObject.ageQuerySubLogic(age);
		List<Student> result = StreamSupport.stream(studentEntityIt.spliterator(), false).map(entity->{
			return updateStudentData(entity);
			}).collect(Collectors.toList());
		return result;
	}
	
	@Override
	public Boolean exists(Long id) {
		 return studentsubLogicObject.existsSubLogic(id);
	}
	
	@Override
	public Boolean existswithPredicate(String name) {
		return studentsubLogicObject.existswithPredicateSubLogic(name);
	}
	
	@Override
	public Boolean existsWitheXample() {
		
		return studentsubLogicObject.existsWithExampleSubLogic();
	}
	
	@Override
	public Long countExampleusingPredicate() {
		 
		return studentsubLogicObject.countwithPredicateSubLogic();
	}
	
	@Override
	public Long countusingExampleClass() {
		return studentsubLogicObject.countwithexampleclassSubLogic();
	}
	
	@Override
	public Long countallindb() {
		return studentsubLogicObject.countallindbSubLogic();
	}
	
	@Override
	public List<Student> findexamplewithiterableLogic() {
		Iterable<StudentEntity> studentlist = studentsubLogicObject.findexamplewithiterableSubLogic();
		List<Student> result = StreamSupport.stream(studentlist.spliterator(), false).map(entity->{
			return updateStudentData(entity);
			}).collect(Collectors.toList());
			return result;
	}
	
	@Override
	public List<Student> findAllwithSortclassLogic() {
		 List<StudentEntity> studentlist = studentsubLogicObject.findAllwithSortclassSubLogic();
		 List<Student>result = studentlist.stream().map(entity->{
			 return updateStudentData(entity);
				}).collect(Collectors.toList());
				
			return result;
	}
	
	@Override
	public List<Student> sortwithExampleclassLogic() {
		
		List<StudentEntity> studentlist = studentsubLogicObject.sortwitsortwithExampleclassSubLogic();
		List<Student> result = studentlist.stream().map(entity->{
			return updateStudentData(entity);
			}).collect(Collectors.toList());
			
		return result;
	}
	
	@Override
	public List<Student> findAllwithOrderSpecifierClassLogic() {
		Iterable<StudentEntity> studentlist = studentsubLogicObject.findAllwithOrderSpecifierClassSubLogic();
		List<Student> result = StreamSupport.stream(studentlist.spliterator(), false).map(entity->{
			return updateStudentData(entity);
			}).collect(Collectors.toList());
			return result;
	}
	
	@Override
	public List<Student> usingexampleclassLogic() {
		List<StudentEntity> list = studentsubLogicObject.usingexampleclassSubLogic();
		 List<Student> result = list.stream().map(entity->{
			 	return updateStudentData(entity);
				}).collect(Collectors.toList());
				return result;
	}
	
	@Override
	public List<Student> usingbasicexampleclassLogic() {
		List<StudentEntity> studentlist  = studentsubLogicObject.usingbasicexampleclassSubLogic();
		
		 List<Student>result = studentlist.stream().map(entity->{
			 	return updateStudentData(entity);
				}).collect(Collectors.toList());
				return result;	
	}
	
	private StudentPage studentPageAddData(Page<StudentEntity> page)
	{

		List<Student>result = page.stream().map(entity->{
			return updateStudentData(entity);
			}).collect(Collectors.toList());
		
		StudentPage studentpage = new StudentPage();
		studentpage.setCurrentPageNo(page.getNumber());
		studentpage.setTotalpages(page.getTotalPages());
		studentpage.setStudentlist(result);
		
		return studentpage;
	}
	
	@Override
	public StudentPage usingPageableclassLogic(Integer pageno) {
		
		Page<StudentEntity> page = studentsubLogicObject.usingPageableclassSubLogic(pageno);
			
		return studentPageAddData(page);
	}
	
	@Override
	public StudentPage usingPageablewithSortingclassLogic(Integer pageno) {
		Page<StudentEntity> sortedpage = studentsubLogicObject.usingPageableclasswithSortclassSubLogic(pageno);
		return studentPageAddData(sortedpage);
	}
	
	@Override
	public StudentPage usingPageablewithPredicateclassLogic(Integer pageno) {
		
		Page<StudentEntity> pagelist = studentsubLogicObject.usingPageablewithPredicateclassSubLogic(pageno);
		return studentPageAddData(pagelist);
	}
	
	@Override
	public void deleteusingIdclassLogic(Long id) {
		studentsubLogicObject.deleteusingIdclassSubLogic(id);
	}
	
	@Override
	public void usingdeletewithiterableclassLogic() {
		studentsubLogicObject.usingDeleteWithIterableClassSubLogic();
	}
	
	@Override
	public void usingdeleteinbatchclassLogic() {
		studentsubLogicObject.usingdeleteinbatchclassLogicSubLogic();
	}
	
	@Override
	public Page<Student> findPaginatedLogicClass(Integer page, Integer size) {
		
		Page<StudentEntity> pageresult = studentsubLogicObject.findPaginatedSubLogicClass(page, size);
		
		
		List<Student> pagelist = pageresult.stream().map(studententity->{
			return updateStudentData(studententity);
		}).collect(Collectors.toList());
		
		final Page<Student> page1 = new PageImpl<>(pagelist);
		return page1;
	}
	
	@Override
	public List<Student> getLikeExample() {
		
		List<StudentEntity> studentList = studentsubLogicObject.getLikeExampleEntity();
		
		List<Student> result = StreamSupport.stream(studentList.spliterator(), false).map(entity->{
			return updateStudentData(entity);
			}).collect(Collectors.toList());
			return result;
				}
}
