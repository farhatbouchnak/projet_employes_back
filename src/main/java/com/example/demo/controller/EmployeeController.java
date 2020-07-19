package com.example.demo.controller;

import java.io.IOException;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.utils.Constants;

@RestController
@RequestMapping(value = Constants.EMPLOYEE)
public class EmployeeController {

	private EmployeeService employeeService;

	/**
	 * injection par constructeur du dependence
	 * 
	 * @param employeeService
	 */
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * retourne une liste des salariées selon les critéres
	 * @since 18/07/2020
	 * @param file
	 * @param salary
	 * @return Set<Employee>
	 * @throws IOException
	 */
	@CrossOrigin
	@PostMapping(value = Constants.GET_EMPLOYEES_BY_CRITERIA)
	public Set<Employee> getEmployeesByCriteria(@RequestPart("file")  MultipartFile file, @PathVariable double salary) throws IOException {
		return employeeService.getEmployeesByCriteria(file, salary);
	}
}
