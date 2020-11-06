package com.insurance.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.insurance.model.Enrollee;

public interface EnrolleeService {
	
	List<Enrollee> getEnrollees();
	Enrollee createEnrollee(Enrollee enrollee);
	Enrollee updateEnrollee(Enrollee enrollee);
	ResponseEntity<?> deleteEnrollee(long enrolleeId);

}
