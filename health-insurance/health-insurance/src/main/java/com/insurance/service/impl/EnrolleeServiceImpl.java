package com.insurance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.insurance.exception.InternalServerException;
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
		return saveEnrollee(enrollee);
	}

	@Override
	public Enrollee updateEnrollee(Enrollee enrollee) {
		return enrolleeRepository.findById(enrollee.getId()).map(enrolleeObj -> {
			enrolleeObj.setActivationStatus(enrollee.isActivationStatus());
			enrolleeObj.setBirthDate(enrollee.getBirthDate());
			enrolleeObj.setName(enrollee.getName());
            return saveEnrollee(enrolleeObj);
        }).orElseThrow(() -> new ResourceNotFoundException("EnrolleeId " + enrollee.getId() + " not found"));

	}

	@Override
	public ResponseEntity<?> deleteEnrollee(long enrolleeId) {
		return enrolleeRepository.findById(enrolleeId).map(enrollee -> {
			enrolleeRepository.delete(enrollee);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("EnrolleeId " + enrolleeId + " not found"));
	}
	
	private Enrollee saveEnrollee(Enrollee enrollee) {
		try {
			return enrolleeRepository.save(enrollee);
		} catch (Exception e) {
				throw new InternalServerException("error while saving enrollee: ");
		}
	}

}
