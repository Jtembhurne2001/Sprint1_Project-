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

import com.exampleSms.Exception.CourseResourseNoutFound;
import com.exampleSms.dao.CourseDao;
import com.exampleSms.model.Course;

@RestController
@RequestMapping("/api/v1/")
public class CourseController {
	@Autowired
	private CourseDao dao;
	@PostMapping("/Course")
	public String bookCourse(@RequestBody List<Course> courses)
	{
		dao.saveAll(courses);
		return "Course are Added:"+courses.size();
		
	}
	@GetMapping("/Course")
	public List<Course> getCourse()
	{
		return(List<Course>)dao.findAll();
	}
	@DeleteMapping("/Course/{id}")
	public ResponseEntity<Map <String, Boolean>> deleteCourse(@PathVariable int id)
	{
		Course course =dao.findById(id).orElseThrow(()-> new CourseResourseNoutFound("Course not be blank"));
		dao.delete(course);
		Map<String, Boolean> response = new HashMap<>();
		return ResponseEntity.ok(response);
	}
	@PutMapping("/Course/{id}")
	public ResponseEntity<Course> updateCourse(@RequestBody Course CourseDetails, @PathVariable int id)
	{
		Course course = dao.findById(id).orElseThrow(()-> new CourseResourseNoutFound("Course not be blank"));
		course.setName(CourseDetails.getName());
		course.setFee(CourseDetails.getFee());
		course.setDuration(CourseDetails.getDuration());
		
		Course updateCourse=dao.save(course);
		return ResponseEntity.ok(updateCourse);
		
	}
	 @GetMapping("/Course/{id}")
	    public ResponseEntity<Course> geCourseById(@PathVariable int id) 
	 {
		 Course course = dao.findById(id).orElseThrow(() -> new CourseResourseNoutFound("course not found for ID: "));
	        return ResponseEntity.ok(course);
	 }
	 

	

}
