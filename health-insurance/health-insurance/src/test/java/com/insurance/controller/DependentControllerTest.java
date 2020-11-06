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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.insurance.model.Dependent;
import com.insurance.service.DependentService;

@WebMvcTest(controllers = DependentController.class)
@RunWith(SpringRunner.class)
public class DependentControllerTest {

	@MockBean
	private DependentService dependentService;

	@InjectMocks
	private DependentController dependentController;

	@Before
	public void setup() {
		initMocks(this);
	}

	@Test
	public void testGetDependentsByEnrolleeId() throws Exception {
		List<Dependent> dependents = new ArrayList<>();
		dependents.add(new Dependent());
		when(dependentService.getDependentsByEnrolleeId(anyLong())).thenReturn(dependents);

		assertNotNull(dependentController.getDependentsByEnrolleeId(101l));
	}

	@Test
	public void testCreateDependent() throws JsonProcessingException, Exception {
		when(dependentService.createDependent(any(Dependent.class))).thenReturn(new Dependent());
		Dependent dependent = new Dependent();

		assertNotNull(dependentController.createDependent(dependent));
	}

	@Test
	public void testUpdateDependent() {
		when(dependentService.updateDependent(any(Dependent.class))).thenReturn(new Dependent());
		Dependent dependent = new Dependent();

		assertNotNull(dependentController.updateDependent(dependent));
	}

	@Test
	public void testRemoveDependent() {
		when(dependentService.removeDependent(anyLong(), anyLong())).thenReturn(new ResponseEntity<>(HttpStatus.OK));
		assertNotNull(dependentController.removeDependent(101l, 102l));
	}

}
