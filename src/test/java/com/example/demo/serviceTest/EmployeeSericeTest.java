package com.example.demo.serviceTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeSericeTest extends TestCase {

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void shouldFindListEmployeesByCriteria() throws Exception {
		//Fichier employees.json pour tester le service.
		File file = new File("src/main/resources/employees.json");
		byte[] content = null;
		try {
			content = Files.readAllBytes(file.toPath());
		} catch (final IOException e) {
			e.printStackTrace();
		}
		MultipartFile employeesJson = new MockMultipartFile(file.getPath(), file.getPath(), "application/json",
				content);
		Set<Employee> emps = employeeService.getEmployeesByCriteria(employeesJson, 10000);
		assertTrue(emps != null && !emps.isEmpty());
	}
}
