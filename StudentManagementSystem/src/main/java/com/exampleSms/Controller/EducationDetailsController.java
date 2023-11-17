package com.exampleSms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.exampleSms.model.EducationDetails;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EducationDetailsController {
	@Autowired
	private EducationDetails dao;
	
	@GetMapping("/edu")
	public List<EducationDetails> getAllEducationDetails()
	{
		return dao.findAll();
		
	}
	
	@PostMapping("/edu")
	public EducationDetails createEducationDetails(@RequestBody EducationDetails edu)
	{
		return dao.save(edu);
		
	}
	/*@PutMapping("/edu/{id}")
	public ResponseEntity<EducationDetails> updateDepartment(@RequestBody EducationDetails educationdetails,@PathVariable int id)
	{
		EducationDetails edu=((Object) dao.findById(id)).orElseThrow(()-> new EducationDetailsResourseNoutFoundException("EducationDetails id cant be blank"));
		edu.setDegree(educationdetails.getDegree());
		edu.setPercentage(educationdetails.getPercentage());
		
		EducationDetails updatedEducationDetails=dao.save(edu);
		return ResponseEntity.ok(updatedEducationDetails);
	}
	
	@DeleteMapping("/departments/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDepartment(@PathVariable int id)
	{
		Department department= dr.findById(id).orElseThrow(()-> new DepartmentResourseNoutFound("EducationDetails id cant be blank"));
		
		dr.delete(department);
		Map<String, Boolean>response=new HashMap<>();
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/departments/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable int id)
	{
		Department department = dr.findById(id).orElseThrow(()-> new DepartmentResourseNoutFound("EducationDetails id cant be blank"));
		return ResponseEntity.ok(department);
	}*/

}
