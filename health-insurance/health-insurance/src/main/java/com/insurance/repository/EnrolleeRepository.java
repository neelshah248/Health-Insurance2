package com.insurance.repository;

import org.springframework.data.repository.CrudRepository;

import com.insurance.model.Enrollee;

public interface EnrolleeRepository extends CrudRepository<Enrollee, Long> {

}
