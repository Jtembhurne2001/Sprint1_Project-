package com.exampleSms.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleSms.Exception.TestResourseNoutFoundException;
import com.exampleSms.dao.TestDao;
import com.exampleSms.model.Test;
@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestDao dao;
	@PostMapping("/test")
	public String AddTest(@RequestBody List<Test> test)
	{
		dao.saveAll(test);
		return "Student Added:"+test.size();
		
	}
	@GetMapping("/gettest")
	public List<Test> getStudent()
	{
		return(List<Test>)dao.findAll();
	}
	@PutMapping("/test/{id}")
	public ResponseEntity<Test> updateStudent(@RequestBody Test testDetails,@PathVariable int id)
	{
		Test test=dao.findById(id).orElseThrow(()-> new TestResourseNoutFoundException("Test id cant be blank"));
		test.setTest_name(testDetails.getTest_name());
		test.setStu_marks(testDetails.getStu_marks());
		
		Test test1=dao.save(test);
		return ResponseEntity.ok(test1);
	}
	
	@DeleteMapping("/test/{id}")
	public ResponseEntity<Map<String, Boolean>> deletetest(@PathVariable int id)
	{
		Test test= dao.findById(id).orElseThrow(()-> new TestResourseNoutFoundException("Test id cant be blank"));
		
		dao.delete(test);
		Map<String, Boolean>response=new HashMap<>();
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/test/{id}")
	public ResponseEntity<Test> getDepartmentById(@PathVariable int id)
	{
		Test test = dao.findById(id).orElseThrow(()-> new TestResourseNoutFoundException("test id cant be blank"));
		return ResponseEntity.ok(test);
	}


}


