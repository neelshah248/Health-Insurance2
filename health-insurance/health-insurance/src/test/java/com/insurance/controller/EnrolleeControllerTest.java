package com.insurance.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.insurance.model.Enrollee;
import com.insurance.service.EnrolleeService;

@WebMvcTest(controllers = EnrolleeController.class)
@RunWith(SpringRunner.class)
public class EnrolleeControllerTest {

	@InjectMocks
	private EnrolleeController enrolleeController;

	@MockBean
	private EnrolleeService enrolleeService;

	@Before
	public void setup() {
		initMocks(this);
	}

	@Test
	public void testGetEnrollees() {
		List<Enrollee> enrollees = new ArrayList<>();
		enrollees.add(new Enrollee());
		when(enrolleeService.getEnrollees()).thenReturn(enrollees);
		assertNotNull(enrolleeController.getEnrollees());
	}

	@Test
	public void testCreateEnrollee() {
		when(enrolleeService.createEnrollee(any(Enrollee.class))).thenReturn(new Enrollee());
		assertNotNull(enrolleeController.createEnrollee(new Enrollee()));
	}

	@Test
	public void testUpdateEnrollee() {
		when(enrolleeService.updateEnrollee(any(Enrollee.class))).thenReturn(new Enrollee());
		assertNotNull(enrolleeController.updateEnrollee(new Enrollee()));
	}

	@Test
	public void testDeleteEnrollee() {
		when(enrolleeService.deleteEnrollee(anyLong())).thenReturn(new ResponseEntity<>(HttpStatus.OK));

		assertNotNull(enrolleeController.deleteEnrollee(101l));
	}

}
