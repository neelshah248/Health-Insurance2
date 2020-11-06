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
import com.insurance.repository.DependentRepository;
import com.insurance.repository.EnrolleeRepository;

public class DependentServiceImplTest {

	@Mock
	private EnrolleeRepository enrolleeRepository;

	@Mock
	private DependentRepository dependentRepository;

	@InjectMocks
	private DependentServiceImpl dependentServiceImpl;

	@Before
	public void setup() {
		initMocks(this);
	}

	@Test
	public void testGetDependentsByEnrolleeId() {
		when(dependentRepository.findByEnrolleeId(any())).thenReturn(new ArrayList<>());
		assertNotNull(dependentServiceImpl.getDependentsByEnrolleeId(101));
	}

	@Test
	public void testCreateDependent() {
		when(enrolleeRepository.existsById(any())).thenReturn(true);
		when(dependentRepository.save(any())).thenReturn(new Dependent(101, "dep1", "1990", 1));
		assertNotNull(dependentServiceImpl.createDependent(new Dependent(101, "dep1", "1990", 1)));
	}

	@Test
	public void testUpdateDependent() {
		when(enrolleeRepository.existsById(any())).thenReturn(true);
		Dependent dependent = new Dependent(101, "dep1", "1990", 1);
		when(dependentRepository.findById(any())).thenReturn(Optional.of(dependent));
		when(dependentRepository.save(any())).thenReturn(dependent);
		assertNotNull(dependentServiceImpl.updateDependent(dependent));

	}

	@Test
	public void testRemoveDependent() {
		Dependent dependent = new Dependent();
		when(dependentRepository.findByIdAndEnrolleeId(any(), any())).thenReturn(Optional.of(dependent));
		doNothing().when(dependentRepository).delete(any());
		ResponseEntity<?> response = dependentServiceImpl.removeDependent(101, 102);
		assertTrue(response.getStatusCode().is2xxSuccessful());
	}
}
