/**
 * 
 */
package com.mind.logic.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mind.dao.StudentDAO;
import com.mind.dao.StudentMarksDAO;
import com.mind.entity.QStudentEntity;
import com.mind.entity.StudentEntity;
import com.mind.entity.StudentMarksEntity;
import com.mind.logic.StudentSubLogic;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;


/**
 * @author mrinalvatsya
 *
 */
@Service
@Transactional
public class StudentSubLogicImpl implements StudentSubLogic {

	@Resource
	StudentDAO studentDAO;

	@Resource

	StudentMarksDAO studentMarksDAO;
	@Override
	public List<StudentEntity> getStudent_List()
	{
		return studentDAO.findAll();
	}

	@Override
	public Optional<StudentEntity> getStudentByid(Long id) {

		Optional<StudentEntity> result = studentDAO.findById(id);
		return result;
	}

	@Override
	public Long addStudentSubLogic(StudentEntity entity) {

		studentDAO.save(entity);
		return entity.getId();
	}

	@Override
	public Long createStudentMarks(StudentMarksEntity marksentity) {

		studentMarksDAO.save(marksentity);
		return marksentity.getId();
		//return marksentity.getId();
	}

	@Override
	public void deleteStudentClassSubLogic(Long id) {

		studentMarksDAO.deleteById(id);
	}

	@Override
	public void deleteStudentClassSubLogic(StudentMarksEntity marksentity) {

		studentMarksDAO.delete(marksentity);
	}
	@Override
	public void deleteFromStudentMarksTable(Long id) {

		studentMarksDAO.deleteById(id);
	}

	@Override
	public Iterable<StudentEntity> ageQuerySubLogic(Integer age) {
		// TODO Auto-generated method stub

		Predicate predicate = QStudentEntity.studentEntity.age.goe(age);
		Iterable<StudentEntity> studentEntityIt = studentDAO.findAll(predicate);
		return studentEntityIt;
	}

	@Override
	public Boolean existsSubLogic(Long id) {

		return studentDAO.existsById(id);
	}

	@Override
	public Boolean existswithPredicateSubLogic(String name) {

		Predicate predicate = 	QStudentEntity.studentEntity.name.eq(name);
		return studentDAO.exists(predicate);
	}

	@Override
	public Boolean existsWithExampleSubLogic() {

		//find any name in database containing string "ni"..
		StudentEntity probe = new StudentEntity();
		probe.setName("ni");
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING).withIgnoreCase();

		Example<StudentEntity> example =  Example.of(probe, matcher);

		return studentDAO.exists(example);
	}

	@Override
	public Long countwithPredicateSubLogic() {
		Integer age = 34;
		Predicate predicate = QStudentEntity.studentEntity.age.goe(age);
		return studentDAO.count(predicate);
	}

	@Override
	public Long countwithexampleclassSubLogic() {

		//find all names in database ending with "h".
		StudentEntity student = new StudentEntity();
		student.setName("h");
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.ENDING).withIgnoreCase();
		Example<StudentEntity> example = Example.of(student, matcher);

		return studentDAO.count(example);
	}

	@Override
	public Long countallindbSubLogic() {
		return studentDAO.count();
	}

	@Override
	public Iterable<StudentEntity> findexamplewithiterableSubLogic() {

		List<Long> ids = Arrays.asList(1L,2L);
		Iterable<StudentEntity> studentlist = studentDAO.findAllById(ids);
		return studentlist;
	}

	@Override
	public List<StudentEntity> findAllwithSortclassSubLogic() {

		Sort sort = new Sort(Sort.Direction.ASC,"age");
		List<StudentEntity> studentlist = studentDAO.findAll(sort);
		return  studentlist;
	}

	@Override
	public List<StudentEntity> sortwitsortwithExampleclassSubLogic() {

		StudentEntity probe = new StudentEntity();
		probe.setName("h");

		ExampleMatcher exp = ExampleMatcher.matching().withStringMatcher(StringMatcher.ENDING).withIgnoreCase();

		Example<StudentEntity> ex = Example.of(probe, exp);

		//using sort class to sort..
		Sort sort = new Sort(Sort.Direction.ASC,"age");
		List<StudentEntity> list = studentDAO.findAll(ex, sort);

		return list;
	}

	@Override
	public Iterable<StudentEntity> findAllwithOrderSpecifierClassSubLogic() {

		BooleanExpression obj = QStudentEntity.studentEntity.age.goe(25);
		OrderSpecifier<Integer> orderspecifier = QStudentEntity.studentEntity.age.asc();
		Iterable<StudentEntity> list = studentDAO.findAll(obj, orderspecifier);
		return list;
	}

	@Override
	public List<StudentEntity> usingexampleclassSubLogic() {
		StudentEntity filterby = new StudentEntity();
		filterby.setName("in");
		//use of ExampleMatcher - find all names of student containing string "in" 
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING).withIgnoreCase();

		Example<StudentEntity> example = Example.of(filterby, matcher);

		//finding all such students using example specified..
		List<StudentEntity>list = studentDAO.findAll(example);

		//counting all such examples in database..
		Long ans = studentDAO.count(example);

		return list;
	}

	@Override
	public List<StudentEntity> usingbasicexampleclassSubLogic() {
		//find student name "mrinal" in db..
		StudentEntity filterby = new StudentEntity();
		filterby.setName("mrinal");

		Example<StudentEntity> example1 = Example.of(filterby); 


		List<StudentEntity> findname = studentDAO.findAll(example1);

		return findname;
	}

	@Override
	public Page<StudentEntity> usingPageableclassSubLogic(Integer pageno) {
		//	Pageable pg = new PageRequest(0, 5);

		Pageable pg = PageRequest.of(pageno, 2);
		Page<StudentEntity>page = studentDAO.findAll(pg);

		return page;
	}

	@Override
	public Page<StudentEntity> usingPageableclasswithSortclassSubLogic(Integer pageno) {

		Sort sort = new Sort(Sort.Direction.ASC,"age");
		Pageable pg = PageRequest.of(pageno, 3, sort);

		Page<StudentEntity> page = studentDAO.findAll(pg);

		return page;
	}

	@Override
	public Page<StudentEntity> usingPageablewithPredicateclassSubLogic(Integer pageno) {

		Pageable pg = PageRequest.of(pageno, 3);

		Predicate predicate = QStudentEntity.studentEntity.age.between(19, 40);

		Page<StudentEntity> list = studentDAO.findAll(predicate, pg);

		return list;
	}

	@Override
	public void deleteusingIdclassSubLogic(Long id) {
		studentDAO.deleteById(id);
	}

	@Override
	public void deleteusingEntityclassSubLogic(StudentEntity entity) {
		studentDAO.delete(entity);
	}

	@Override
	public void usingDeleteWithIterableClassSubLogic() {
		//delete student having roll nos 1,2,3.
		List<Long> arr = Arrays.asList(7L,8L,9L,10L,13L,15L,16L,17L,18L,21L,23L,24L,27L,34L,45L,56L,57L,67L,78L,98L,103L,121L,456L,500L,501L,502L,503L,504L,505L);

		List<StudentEntity> list = studentDAO.findAllById(arr);

		studentDAO.deleteAll(list);
	}

	@Override
	public void usingdeleteinbatchclassLogicSubLogic() {

		studentDAO.deleteAllInBatch();
	}

	@Override
	public Page<StudentEntity> findPaginatedSubLogicClass(Integer page, Integer size) {
		Pageable pg = PageRequest.of(page, size);
		return studentDAO.findAll(pg);
	}

	@Override
	public List<StudentEntity> getLikeExampleEntity() {

		List<String> nameArray = new ArrayList<>();
		nameArray.addAll(Arrays.asList("mrina", "t"));

		List<StudentEntity> finalList = new ArrayList<>();//for final answer...

		nameArray.forEach(nameEntity->{

			Predicate predicate = QStudentEntity.studentEntity.name.like((Expressions.asString("%").concat(nameEntity).concat("%")));
			Iterable<StudentEntity> studentList = studentDAO.findAll(predicate);

			List<StudentEntity> studentsList = StreamSupport.stream(studentList.spliterator(), false).collect(Collectors.toList());
			finalList.addAll(studentsList);
		});
		return finalList;
	}
}
