/**
 * 
 */
package com.mind.controller;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mind.dto.Student;
import com.mind.dto.StudentPage;
import com.mind.entity.StudentEntity;
import com.mind.exception.MyResourceNotFoundException;
import com.mind.hateoas.event.PaginatedResultsRetrievedEvent;
import com.mind.logic.StudentDeleteLogic;
import com.mind.logic.StudentLogic;
import com.mind.logic.StudentSubLogic;
import com.mind.logic.impl.StudentLogicImpl;
/**
 * @author mrinalvatsya
 *
 */
@RestController
@RequestMapping("/getme")
public class GreetingController {
	
	@Autowired
	StudentLogic studentLogicLayerObject;
	
	@Autowired
	StudentDeleteLogic studentDeleteLogic;
	
	@Autowired
    private ApplicationEventPublisher eventPublisher;
		
	@RequestMapping("/hello")
	ResponseEntity<String> hello() {
	    return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}
	
	@GetMapping("/customHeader")
	ResponseEntity<String> customHeader() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Custom-Header", "foo");
	         
	    return new ResponseEntity<>(
	      "Custom header set", headers, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public List<Student> findPaginated(@RequestParam("page") Integer page, @RequestParam("size") Integer size, final UriComponentsBuilder uriBuilder, final HttpServletResponse response) {
        final Page<Student> resultPage = studentLogicLayerObject.findPaginatedLogicClass(page,size);
        if (page > resultPage.getTotalPages()) {
            throw new MyResourceNotFoundException();
        }
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<Student>(Student.class, uriBuilder, response, page, resultPage.getTotalPages(), size));

        return resultPage.getContent();
    }
	
	@RequestMapping("getList")
	List<Student> getStudentList()
	{
		List<Student> students = studentLogicLayerObject.getListofStudent();
		return students;
	}
	
	@RequestMapping("getstudentbyrollno")//get method..
	public Student student(@RequestParam(value="rollNo",required=true)Long rollNo)
	{
		return studentLogicLayerObject.getStudentByRollNo(rollNo);
	}	
	
	@RequestMapping(value = "addstudent",method = RequestMethod.POST)//post method..
	public Student addStudent(@RequestBody Student student) {
		
		return studentLogicLayerObject.addStudent(student);
	}
	
	@RequestMapping(value = "studentUpdate/{rollNo}",method = RequestMethod.PUT)//put method..
	public void modifyStudent(@RequestBody Student student, @PathVariable("rollNo") Long rollNo) {
		
		studentLogicLayerObject.studentUpdate(student,rollNo);
		}	
	
	@RequestMapping(value = "deletestudent/{rollNo}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable("rollNo")Long rollNo)
	{
		studentDeleteLogic.deleteStudentClassLogic(rollNo);
	}
	
	@RequestMapping("agequery")
	public List<Student> getStudentDetails(@RequestParam(value="age",required=false)Integer age1) 
	{
		List<Student> studentlist = studentLogicLayerObject.ageQuery(age1);
		return studentlist;
	}
	
	@RequestMapping("existsexample")//using exists example..
	Boolean existsexample(@RequestParam(value="rollNo",required=true)Long rollNo)
	{
		return studentLogicLayerObject.exists(rollNo);
	}
	
	@RequestMapping("existswithpredicate")
	Boolean existsExamplewithpredicate(@RequestParam(value="name",required = true)String name)
	{
		return studentLogicLayerObject.existswithPredicate(name);
	}
	
	@RequestMapping("existswithexample")
	Boolean existsWithExample()
	{
		//find any name in database containing string "ni"..
		return studentLogicLayerObject.existsWitheXample();
	}
	
	@RequestMapping("countentity")
	Long countrecords()
	{
		//count number of records in database..
		return studentLogicLayerObject.countallindb();
	}
	
	@RequestMapping("countexample")//count example using predicate
	Long countExamplewithPRedicate()
	{
		return studentLogicLayerObject.countExampleusingPredicate();
	}
	
	@RequestMapping("countusingexample")//count example using example
	Long countwithexample()
	{
		//find all students whose names are ending with "h"
		 return studentLogicLayerObject.countusingExampleClass();
	}
	
	@RequestMapping("findAllwithiterable")//use of findallbyid..
	public List<Student> findexamplewithIterable()
	{
		//use of findAllById using Iterable.
			List<Student> studentlist = studentLogicLayerObject.findexamplewithiterableLogic();
			return studentlist;
	}
	
	@RequestMapping("findAllwithSort")//using Sort class for sorting..
	public List<Student> findAllwithSortclass()
	{
		//sort on the basis of age..
		List<Student> result = studentLogicLayerObject.findAllwithSortclassLogic();	
		return result;
	}
	
	@RequestMapping("sortwithexampleclass")//using sort class with example..
	public List<Student> sortwithExampleclass()
	{
		//sort on the basis of age having names ending with "h"..
		List<Student> listofstudents = studentLogicLayerObject.sortwithExampleclassLogic();
		return listofstudents;
	}
	
	@RequestMapping("findAllwithOrderSpecifier")//use of findall for sorting..
	List<Student> findAllwithOrderSpecifierClass()
	{
		//use of orderSpecifier..
		//find all students having age>=25 
		//Sort them on basis of age..
		List<Student> studentlist = studentLogicLayerObject.findAllwithOrderSpecifierClassLogic();
		return studentlist;
	}
	
	@RequestMapping("exampleclasswithmatcher")//use of example in spring 
	List<Student> usingexampleclass()
	{
		  //use of ExampleMatcher - find all names of student containing string "in" 
		List<Student> studentList = studentLogicLayerObject.usingexampleclassLogic();
		return studentList;
	}
	
	@RequestMapping("examleclassbasic")
	List<Student> usingbasicexampleclass()
	{
		//find using example a student with name mrinal in database..
		List<Student> studentlist = studentLogicLayerObject.usingbasicexampleclassLogic();
		return studentlist;
	}
	
	@RequestMapping("paginationexample/{pageno}")//using pageable for pagination..
	public StudentPage usingpaginationexample(@PathVariable("pageno")Integer pageno)
	{
		StudentPage studentlist = studentLogicLayerObject.usingPageableclassLogic(pageno);
		return studentlist;
	}
	
	@RequestMapping("pagewithsort/{pageno}")//applying sorting to page
	public StudentPage pagingwithsortingexample(@PathVariable("pageno")Integer pageno)
	{
		StudentPage studentlist = studentLogicLayerObject.usingPageablewithSortingclassLogic(pageno);
		return studentlist;
	}
	
	@RequestMapping("pagewithpredicate/{pageno}")
	public StudentPage usingpagingwithpredicate(@PathVariable("pageno")Integer pageno)//using predicates with Pageable..
	{
		StudentPage pagelist = studentLogicLayerObject.usingPageablewithPredicateclassLogic(pageno);
		return pagelist;
	}
	
	@RequestMapping("deletebyid")
	void deletebyidexample(@RequestParam(value = "id" , required = true)Long id)
	{
		studentLogicLayerObject.deleteusingIdclassLogic(id);//Deletes student id equal to 1
		//studentDAO.deleteAll();//Deletes all from database..
	}
	
	
	@RequestMapping("deletewithiterable")//using iterable delete
	void deleteusingiterable()//delete student having roll nos 1,2,3.
	{
		studentLogicLayerObject.usingdeletewithiterableclassLogic();
	}
	
	@RequestMapping("deleteinBatch")//deleteInbatch
	void deletewithBatch()
	{
		studentLogicLayerObject.usingdeleteinbatchclassLogic();
	}

	/**
	 * @return the studentLogicLayerObject
	 */
	public StudentLogic getStudentLogicLayerObject() {
		return studentLogicLayerObject;
	}

	/**
	 * @param studentLogicLayerObject the studentLogicLayerObject to set
	 */
	public void setStudentLogicLayerObject(StudentLogic studentLogicLayerObject) {
		this.studentLogicLayerObject = studentLogicLayerObject;
	}

	/**
	 * @return the studentDeleteLogic
	 */
	public StudentDeleteLogic getStudentDeleteLogic() {
		return studentDeleteLogic;
	}

	/**
	 * @param studentDeleteLogic the studentDeleteLogic to set
	 */
	public void setStudentDeleteLogic(StudentDeleteLogic studentDeleteLogic) {
		this.studentDeleteLogic = studentDeleteLogic;
	}
	
	@RequestMapping("likeExample")
	public List<Student> likeExample()
	{
		List<Student> studentData = studentLogicLayerObject.getLikeExample();
		return studentData;
	}
}
