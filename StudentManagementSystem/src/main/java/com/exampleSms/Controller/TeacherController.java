package com.exampleSms.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleSms.Exception.TeacherResourseNoutFoundException;
import com.exampleSms.dao.TeacherDao;
import com.exampleSms.model.Teacher;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class TeacherController {

	@Autowired
	private TeacherDao dao;
	
	@GetMapping("/Teacher")
	public List<Teacher> getAllTeachers()
	{
		return dao.findAll();
		
	}
	@PostMapping("/Teacher")
	public Teacher createTeacher(@RequestBody Teacher teacher)
	{
		return dao.save(teacher);
		
	}
	@PutMapping("/Teacher/{id}")
	public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacherDetails,@PathVariable int id)
	{
		Teacher teacher=dao.findById(id).orElseThrow(()-> new TeacherResourseNoutFoundException("Teacher id cant be blank"));
		teacher.setTname(teacherDetails.getTname());
		teacher.setCourse(teacherDetails.getCourse());
		teacher.setBatch(teacherDetails.getBatch());
		
		Teacher updatedTeacher= dao.save(teacher);
		return ResponseEntity.ok(updatedTeacher);
	}
	@DeleteMapping("/test/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTeacher(@PathVariable int id)
	{
		Teacher teacher= dao.findById(id).orElseThrow(()-> new TeacherResourseNoutFoundException("Teacher id cant be blank"));
		
		dao.delete(teacher);
		Map<String, Boolean>response=new HashMap<>();
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/test/{id}")
	public ResponseEntity<Teacher> getDepartmentById(@PathVariable int id)
	{
		Teacher teacher = dao.findById(id).orElseThrow(()-> new TeacherResourseNoutFoundException("Teacher id cant be blank"));
		return ResponseEntity.ok(teacher);
	}
}
