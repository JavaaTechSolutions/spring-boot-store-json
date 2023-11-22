package com.jts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jts.entity.DemoDTO;
import com.jts.entity.Employee;
import com.jts.entity.EmployeeRespository;

@Service
public class JpaService {
	private static final Logger log = LoggerFactory.getLogger(JpaService.class);

	@Autowired
	private EmployeeRespository employeeRepository;

	public void save() throws JsonProcessingException {
		DemoDTO demoDTO = new DemoDTO();
		demoDTO.setName("Test");
		demoDTO.setSalary("50K");

		ObjectMapper map = new ObjectMapper();

		Employee emp = new Employee();
		emp.setRequest(map.writeValueAsString(demoDTO));

		employeeRepository.save(emp);

		log.info("Employee saved successfully into database with id {}", emp.getId());
	}

}
