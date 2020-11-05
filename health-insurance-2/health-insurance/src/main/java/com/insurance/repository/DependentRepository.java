package com.insurance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.insurance.model.Dependent;

public interface DependentRepository extends CrudRepository<Dependent, Long> {
	
	List<Dependent> findByEnrolleeId(Long enrolleeId);
	Optional<Dependent> findByIdAndEnrolleeId(Long id, Long enrolleeId);
}
