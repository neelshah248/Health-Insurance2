package com.insurance.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.insurance.model.Dependent;

public interface DependentService {
	
	List<Dependent> getDependentsByEnrolleeId(long enrolleeId);
	Dependent createDependent(long enrolleeId, Dependent dependent);
	Dependent updateDependent(long dependentId, long enrolleeId, Dependent dependent);
	ResponseEntity<?> removeDependent(long dependentId, long enrolleeId);

}
