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

import com.insurance.model.Dependent;
import com.insurance.service.DependentService;

@RestController
public class DependentController {
	
	@Autowired
	private DependentService dependentService;
	
	@GetMapping("/dependents/{enrolleeId}")
	public List<Dependent> getDependentsByEnrolleeId(@PathVariable long enrolleeId) {
		return dependentService.getDependentsByEnrolleeId(enrolleeId);
	}
	
	@PostMapping("/dependents/{enrolleeId}")
	public Dependent createDependent(@PathVariable Long enrolleeId, @RequestBody Dependent dependent) {
		return dependentService.createDependent(enrolleeId, dependent);
	}
	
	@PutMapping("/dependents/{dependentId}/{enrolleeId}")
	public Dependent updateDependent(@PathVariable long dependentId, @PathVariable long enrolleeId, @RequestBody Dependent dependent) {
		return dependentService.updateDependent(dependentId, enrolleeId, dependent);
	}
	
	@DeleteMapping("/dependents/{dependentId}/{enrolleeId}")
	public ResponseEntity<?> removeDependent(@PathVariable long dependentId, @PathVariable long enrolleeId) {
		return dependentService.removeDependent(dependentId, enrolleeId);
	}

}
