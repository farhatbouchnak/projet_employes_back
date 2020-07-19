package com.example.demo.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.SourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * charger tous les salariées selon les critéres choisies
	 * @param MultipartFile
	 * @param double
	 * @return Set<Employee>
	 * @author farhat Bouchnak
	 */
	@Override
	public Set<Employee> getEmployeesByCriteria(@RequestPart("uploadingFiles") MultipartFile uploadingFiles,
			double salary) throws JsonParseException, JsonMappingException, IOException {

		Set<Employee> myset = null;
		try {
			//si le fichier est vide ou il ne contient pas des données
			if (uploadingFiles.isEmpty() || uploadingFiles.getBytes() == null) {
				throw new SourceNotFoundException("Faile to read is empty " + uploadingFiles.getOriginalFilename());
			}
			// creating an InputStreamReader object
			InputStreamReader isReader = new InputStreamReader(uploadingFiles.getInputStream());
			// Creating a BufferedReader object
			BufferedReader reader = new BufferedReader(isReader);
			StringBuffer sb = new StringBuffer();
			String str;
			while ((str = reader.readLine()) != null) {
				sb.append(str);
			}
			logger.info(sb.toString());
			ObjectMapper mapper = new ObjectMapper();
			List<Employee> employees = mapper.readValue(sb.toString(), new TypeReference<List<Employee>>() {
			});
			myset = employees.stream().flatMap(o -> employees.stream().filter(e -> e.getSalary() == salary))
					.collect(Collectors.toSet());
			logger.info(myset.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myset;
	}
}
