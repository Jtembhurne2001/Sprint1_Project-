package com.exampleSms.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.hibernate.mapping.List;
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

import com.exampleSms.Exception.StudentResourseNoutFoundException;
import com.exampleSms.dao.StudentDao;
import com.exampleSms.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentDao dao;
	@PostMapping("/students")
	public String AddStudent(@RequestBody List<Student> students)
	{
		dao.saveAll(students);
		return "Student Added:"+students.size();
		
	}
	@GetMapping("/getStudent")
	public List<Student> getStudent()
	{
		return(List<Student>)dao.findAll();
	}
	@PutMapping("/Student/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student studentDetails,@PathVariable int id)
	{
		Student student=dao.findById(id).orElseThrow(()-> new StudentResourseNoutFoundException("Student id cant be blank"));
		student.setSname(studentDetails.getSname());
		student.setFees(studentDetails.getFees());
		
		Student student2=dao.save(student);
		return ResponseEntity.ok(student2);
	}
	
	@DeleteMapping("/Student/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDepartment(@PathVariable int id)
	{
		Student student= dao.findById(id).orElseThrow(()-> new StudentResourseNoutFoundException("Student id cant be blank"));
		
		dao.delete(student);
		Map<String, Boolean>response=new HashMap<>();
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/Student/{id}")
	public ResponseEntity<Student> getDepartmentById(@PathVariable int id)
	{
		Student student = dao.findById(id).orElseThrow(()-> new StudentResourseNoutFoundException("Student id cant be blank"));
		return ResponseEntity.ok(student);
	}
}

