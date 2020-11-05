package com.insurance.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.insurance.exception.ResourceNotFoundException;
import com.insurance.model.Dependent;
import com.insurance.model.Enrollee;
import com.insurance.repository.DependentRepository;
import com.insurance.repository.EnrolleeRepository;
import com.insurance.service.DependentService;

@Service
public class DependentServiceImpl implements DependentService {
	
	@Autowired
	private EnrolleeRepository enrolleeRepository;
	
	@Autowired
	private DependentRepository dependentRepository;
	
	@Override
	public List<Dependent> getDependentsByEnrolleeId(long enrolleeId) {
		return dependentRepository.findByEnrolleeId(enrolleeId);
	}

	@Override
	public Dependent createDependent(long enrolleeId, Dependent dependent) {
		Optional<Enrollee> enrollee = enrolleeRepository.findById(enrolleeId);
		if(enrollee.isPresent()) {
            return dependentRepository.save(dependent);
		}
		
		throw new ResourceNotFoundException("EnrolleeId " + enrolleeId + " not found");

	}

	@Override
	public Dependent updateDependent(long dependentId, long enrolleeId, Dependent dependent) {
		if(!enrolleeRepository.existsById(enrolleeId)) {
            throw new ResourceNotFoundException("EnrolleeId " + enrolleeId + " not found");
        }

		Optional<Dependent> dependentOptional = dependentRepository.findById(dependentId);
		if(dependentOptional.isPresent()) {
			Dependent  dependentObj = dependentOptional.get();
			dependentObj.setbDate(dependent.getbDate());
        	dependentObj.setName(dependent.getName());
            return dependentRepository.save(dependentObj);
		}
		
		throw new ResourceNotFoundException("DependentId " + dependentId + " not found");
		
	}

	@Override
	public ResponseEntity<?> removeDependent(long dependentId, long enrolleeId) {
		return dependentRepository.findByIdAndEnrolleeId(dependentId, enrolleeId).map(dependent -> {
			dependentRepository.delete(dependent);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Dependent not found with id " + dependentId + " and enrolleeId " + enrolleeId));
    
	}

}
