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

import com.exampleSms.Exception.AttendanceResourseNoutFound;
import com.exampleSms.dao.AttendanceDao;
import com.exampleSms.model.Attendance;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class AttendanceController {

		@Autowired
		private AttendanceDao dao;
		
		@GetMapping("/StudentAttendance")
		public List<Attendance> getAllStudent()
		{
			return dao.findAll();
			
		}
		@PostMapping("/StudentAttendance")
		public Attendance createStudentAttendance(@RequestBody Attendance StudentAttendance)
		{
			return dao.save(StudentAttendance);
			
		}
		@PutMapping("/StudentAttendance/{id}")
		public ResponseEntity<Attendance> updateAttendance(@RequestBody Attendance attendance,@PathVariable int id)
		{
			Attendance attendance1=dao.findById(id).orElseThrow(()-> new AttendanceResourseNoutFound("Attendance id cant be blank"));
			attendance1.setStudent_Name(attendance1.getStudent_Name());
			attendance1.setTeacher_Name(attendance1.getTeacher_Name());
			attendance1.setStudent_Attendance(attendance1.getStudent_Attendance());
		
			Attendance updatedAttendance=dao.save(attendance1);
			return ResponseEntity.ok(updatedAttendance);
		}

		@DeleteMapping("/StudentAttendance/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteAttendance(@PathVariable int id)
		{
			Attendance attendance= dao.findById(id).orElseThrow(()-> new AttendanceResourseNoutFound("Attendance id cant be blank"));
			
			dao.delete(attendance);
			Map<String, Boolean>response=new HashMap<>();
			return ResponseEntity.ok(response);
			
		}
		@GetMapping("/StudentAttendance/{id}")
		public ResponseEntity<Attendance> getAttendancetById(@PathVariable int id)
		{
			Attendance attendance = dao.findById(id).orElseThrow(()-> new AttendanceResourseNoutFound("Attendance id cant be blank"));
			return ResponseEntity.ok(attendance);
		}
		
		@GetMapping("/StudentAttendance/byName/{Student_Name}")
		public List<Attendance> getAttendancesasbyStudent_Name(@PathVariable String Student_Name) {
		     return dao.findBydeptStudent_Name(Student_Name);
		 }
		

	
	

}
