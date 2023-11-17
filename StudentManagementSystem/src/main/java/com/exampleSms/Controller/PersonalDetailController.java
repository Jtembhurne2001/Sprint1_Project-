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
import com.exampleSms.Exception.PersonalDetailsResourseNotFound;
import com.exampleSms.dao.PersonalDetailDao;
import com.exampleSms.model.PersonalDetail;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PersonalDetailController {

	@Autowired
	private PersonalDetailDao dao;
	
	@GetMapping("/PersonalDetail")
	public List<PersonalDetail> getAllDepartment()
	{
		return dao.findAll();
		
	}
	@PostMapping("/PersonalDetail")
	public PersonalDetail createDepartment(@RequestBody PersonalDetail personalDetail)
	{
		return dao.save(personalDetail);
		
	}
	@PutMapping("/PersonalDetail/{id}")
	public ResponseEntity<PersonalDetail> updatePersonalDetail(@RequestBody PersonalDetail personalDetail,@PathVariable int id)
	{
		PersonalDetail personalDetail2=dao.findById(id).orElseThrow(()-> new PersonalDetailsResourseNotFound(" PersonalDetails id cant be blank"));
		personalDetail2.setContactno(personalDetail.getContactno());
		personalDetail2.setEmailID(personalDetail.getEmailID());
		
		PersonalDetail updatedPersonalDetail=dao.save(personalDetail);
		return ResponseEntity.ok(updatedPersonalDetail);
	}
	@DeleteMapping("/PersonalDetail/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePersonalDetail(@PathVariable int id)
	{
		PersonalDetail personalDetail= dao.findById(id).orElseThrow(()-> new  PersonalDetailsResourseNotFound("PersonalDetails id cant be blank"));
		
		dao.delete(personalDetail);
		Map<String, Boolean>response=new HashMap<>();
		return ResponseEntity.ok(response);
		
	}
	@GetMapping("/PersonalDetail/{id}")
	public ResponseEntity<PersonalDetail> getPersonalDetailById(@PathVariable int id)
	{
		PersonalDetail personalDetail = dao.findById(id).orElseThrow(()-> new PersonalDetailsResourseNotFound("PersonalDetails id cant be blank"));
		return ResponseEntity.ok(personalDetail);
	}
}
