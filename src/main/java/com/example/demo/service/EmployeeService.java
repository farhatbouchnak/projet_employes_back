package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Employee;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public interface EmployeeService {

	
	 Set<Employee> getEmployeesByCriteria(MultipartFile  file, double salary)
				throws JsonParseException, JsonMappingException, IOException;
}
