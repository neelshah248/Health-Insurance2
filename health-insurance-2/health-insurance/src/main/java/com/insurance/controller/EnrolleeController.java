package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.Enrollee;
import com.insurance.service.EnrolleeService;

@RestController
public class EnrolleeController {
	
	@Autowired
	private EnrolleeService enrolleeService;
	
	@GetMapping("/enrollees")
	public List<Enrollee> getEnrollees() {
		return enrolleeService.getEnrollees();
	}
	
	@PostMapping("/enrollees")
	public Enrollee createEnrollee(@RequestBody Enrollee enrollee) {
		return enrolleeService.createEnrollee(enrollee);
	}
	
	@PutMapping("/enrollees/{enrolleeId}")
	public Enrollee updateEnrollee(@PathVariable Long enrolleeId, @RequestBody Enrollee enrollee) {
		return enrolleeService.updateEnrollee(enrolleeId, enrollee);
	}
	
	@DeleteMapping("/enrollees/{enrolleeId}")
	public ResponseEntity<?> deleteEnrollee(@PathVariable Long enrolleeId) {
		return enrolleeService.deleteEnrollee(enrolleeId);
	}
}
