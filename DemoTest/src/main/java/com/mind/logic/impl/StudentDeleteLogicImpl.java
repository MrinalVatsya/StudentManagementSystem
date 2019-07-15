/**
 * 
 */
package com.mind.logic.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mind.entity.StudentEntity;
import com.mind.logic.StudentDeleteLogic;
import com.mind.logic.StudentSubLogic;

/**
 * @author mrinalvatsya
 *
 */
@Service
public class StudentDeleteLogicImpl implements StudentDeleteLogic {

	
	@Autowired
	StudentSubLogic studentsubLogicObject;
	
	@Override
	public void deleteStudentClassLogic(Long rollNo) {
			Optional<StudentEntity>  studentEntryOpt = studentsubLogicObject.getStudentByid(rollNo);
			if(studentEntryOpt.isPresent())
			{
				StudentEntity studententity = studentEntryOpt.get();
				if(studententity.getSubjectmarkslist() != null && studententity.getSubjectmarkslist().size() > 0)
				{
					studententity.getSubjectmarkslist().stream().forEach(subject->
					{
						Long deleteid = subject.getId();
						studentsubLogicObject.deleteStudentClassSubLogic(subject);//delete from studentmarks table..
					
					});
				}
				
				studentsubLogicObject.deleteusingEntityclassSubLogic(studententity);//delete from student table..
			}
			else
			{
				System.out.println("Student cannot be deleted");
			}
	}

	/**
	 * @return the studentsubLogicObject
	 */
	public StudentSubLogic getStudentsubLogicObject() {
		return studentsubLogicObject;
	}

	/**
	 * @param studentsubLogicObject the studentsubLogicObject to set
	 */
	public void setStudentsubLogicObject(StudentSubLogic studentsubLogicObject) {
		this.studentsubLogicObject = studentsubLogicObject;
	}
}
