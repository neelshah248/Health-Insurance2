package com.insurance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.insurance.exception.ResourceNotFoundException;
import com.insurance.model.Enrollee;
import com.insurance.repository.EnrolleeRepository;
import com.insurance.service.EnrolleeService;

@Service
public class EnrolleeServiceImpl implements EnrolleeService {
	
	@Autowired
	private EnrolleeRepository enrolleeRepository;
	
	@Override
	public List<Enrollee> getEnrollees() {
		return (List<Enrollee>) enrolleeRepository.findAll();
	}

	@Override
	public Enrollee createEnrollee(Enrollee enrollee) {
		return enrolleeRepository.save(enrollee);

	}

	@Override
	public Enrollee updateEnrollee(long enrolleeId, Enrollee enrollee) {
		return enrolleeRepository.findById(enrolleeId).map(enrolleeObj -> {
			enrolleeObj.setActivationStatus(enrollee.isActivationStatus());
			enrolleeObj.setbDate(enrollee.getbDate());
			enrolleeObj.setName(enrollee.getName());
            return enrolleeRepository.save(enrolleeObj);
        }).orElseThrow(() -> new ResourceNotFoundException("EnrolleeId " + enrolleeId + " not found"));

	}

	@Override
	public ResponseEntity<?> deleteEnrollee(long enrolleeId) {
		return enrolleeRepository.findById(enrolleeId).map(enrollee -> {
			enrolleeRepository.delete(enrollee);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("EnrolleeId " + enrolleeId + " not found"));
	}

}
