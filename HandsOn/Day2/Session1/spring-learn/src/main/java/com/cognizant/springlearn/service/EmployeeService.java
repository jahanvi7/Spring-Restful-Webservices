package com.cognizant.springlearn.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.dao.EmployeeDao;

@Service
public class EmployeeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	@Transactional
	public ArrayList<Employee> getAllEmployees(){
		LOGGER.info("Employee service START");
		LOGGER.debug("Employees : {}",EmployeeDao.getAllEmployees());
		LOGGER.info("Employee service END");
		return EmployeeDao.getAllEmployees();
	}
}
