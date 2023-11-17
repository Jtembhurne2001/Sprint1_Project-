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

import com.exampleSms.Exception.ReportResourseNoutFoundException;
import com.exampleSms.dao.ReportsDao;
import com.exampleSms.model.Reports;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ReportsController {

	@Autowired
	private ReportsDao dao;
	
	@GetMapping("/reports")
	public List<Reports> getAllReport()
	{
		return dao.findAll();
		
	}
	@PostMapping("/reports")
	public Reports createReports(@RequestBody Reports reports)
	{
		return dao.save(reports);
		
	}
	@PutMapping("/reports/{id}")
	public ResponseEntity<Reports> updateReports(@RequestBody Reports ReportsDetails,@PathVariable int id)
	{
		Reports reports=dao.findById(id).orElseThrow(()-> new ReportResourseNoutFoundException("Reports id cant be blank"));
		reports.setCourse_name(ReportsDetails.getCourse_name());
		reports.setStudent_Marks(ReportsDetails.getStudent_Marks());
		
		Reports updatedReport=dao.save(reports);
		return ResponseEntity.ok(updatedReport);
	}
	
	@DeleteMapping("/reports/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDepartment(@PathVariable int id)
	{
		Reports reports= dao.findById(id).orElseThrow(()-> new ReportResourseNoutFoundException("Reports id cant be blank"));
		
		dao.delete(reports);
		Map<String, Boolean>response=new HashMap<>();
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/reports/{id}")
	public ResponseEntity<Reports> getDepartmentById(@PathVariable int id)
	{
		Reports reports = dao.findById(id).orElseThrow(()-> new ReportResourseNoutFoundException("Reports id cant be blank"));
		return ResponseEntity.ok(reports);
	}
	
}
