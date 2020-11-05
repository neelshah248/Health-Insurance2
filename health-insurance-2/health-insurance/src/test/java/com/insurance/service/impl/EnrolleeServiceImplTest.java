package com.insurance.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import com.insurance.model.Dependent;
import com.insurance.model.Enrollee;
import com.insurance.repository.EnrolleeRepository;

public class EnrolleeServiceImplTest {
	
	@Mock
	private EnrolleeRepository enrolleeRepository;
	
	@InjectMocks
	private EnrolleeServiceImpl enrolleeServiceImpl;
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	@Test
	public void testGetEnrollees() {
		when(enrolleeRepository.findAll()).thenReturn(new ArrayList<>());
		assertNotNull(enrolleeServiceImpl.getEnrollees());
	}
	
	@Test
	public void testCreateEnrollee() {
		when(enrolleeRepository.save(any())).thenReturn(new Enrollee());
		assertNotNull(enrolleeServiceImpl.createEnrollee(new Enrollee()));
	}
	
	@Test
	public void testUpdateEnrollee() {
		Enrollee enrollee = new Enrollee();
		when(enrolleeRepository.findById(any())).thenReturn(Optional.of(enrollee));
		when(enrolleeRepository.save(any())).thenReturn(enrollee);
		assertNotNull(enrolleeServiceImpl.updateEnrollee(101, enrollee));
	}
	
	@Test
	public void testDeleteEnrollee() {
		Enrollee enrollee = new Enrollee();
		when(enrolleeRepository.findById(any())).thenReturn(Optional.of(enrollee));
		doNothing().when(enrolleeRepository).delete(any());
		ResponseEntity<?> response = enrolleeServiceImpl.deleteEnrollee(101l);
		assertTrue(response.getStatusCode().is2xxSuccessful());
	}

}
