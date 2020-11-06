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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.Dependent;
import com.insurance.service.DependentService;

@RestController
@RequestMapping("/dependents")
public class DependentController {
	
	@Autowired
	private DependentService dependentService;
	
	@GetMapping("/get/{enrolleeId}")
	public List<Dependent> getDependentsByEnrolleeId(@PathVariable long enrolleeId) {
		return dependentService.getDependentsByEnrolleeId(enrolleeId);
	}
	
	@PostMapping("/save")
	public Dependent createDependent(@RequestBody Dependent dependent) {
		return dependentService.createDependent(dependent);
	}
	
	@PutMapping("/update")
	public Dependent updateDependent(@RequestBody Dependent dependent) {
		return dependentService.updateDependent(dependent);
	}
	
	@DeleteMapping("/delete/{dependentId}/{enrolleeId}")
	public ResponseEntity<?> removeDependent(@PathVariable long dependentId, @PathVariable long enrolleeId) {
		return dependentService.removeDependent(dependentId, enrolleeId);
	}

}
