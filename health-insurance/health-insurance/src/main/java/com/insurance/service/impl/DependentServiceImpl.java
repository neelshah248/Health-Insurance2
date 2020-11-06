package com.insurance.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.insurance.exception.InternalServerException;
import com.insurance.exception.ResourceNotFoundException;
import com.insurance.model.Dependent;
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
	public Dependent createDependent(Dependent dependent) {
		if (!enrolleeRepository.existsById(dependent.getEnrolleeId())) {
			throw new ResourceNotFoundException("EnrolleeId " + dependent.getEnrolleeId() + " not found");
		}
		return saveDependent(dependent);
	}

	@Override
	public Dependent updateDependent(Dependent dependent) {
		if (!enrolleeRepository.existsById(dependent.getEnrolleeId())) {
			throw new ResourceNotFoundException("EnrolleeId " + dependent.getEnrolleeId() + " not found");
		}
		Dependent dependentObj = getDependentById(dependent.getId());
		dependentObj.setBirthDate(dependent.getBirthDate());
		dependentObj.setName(dependent.getName());
		return saveDependent(dependentObj);
	}

	@Override
	public ResponseEntity<?> removeDependent(long dependentId, long enrolleeId) {
		return dependentRepository.findByIdAndEnrolleeId(dependentId, enrolleeId).map(dependent -> {
			dependentRepository.delete(dependent);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException(
				"Dependent not found with id " + dependentId + " and enrolleeId " + enrolleeId));
	}

	private Dependent getDependentById(long dependentId) {
		Optional<Dependent> dependentOptional = dependentRepository.findById(dependentId);
		if (!dependentOptional.isPresent()) {
			throw new ResourceNotFoundException("DependentId " + dependentId + " not found");
		}
		return dependentOptional.get();
	}
	
	private Dependent saveDependent(Dependent dependent) {
		try {
			return dependentRepository.save(dependent);
		} catch (Exception e) {
			throw new InternalServerException("error while saving dependent for enrollee: " + dependent.getEnrolleeId());
		}
	}
}
