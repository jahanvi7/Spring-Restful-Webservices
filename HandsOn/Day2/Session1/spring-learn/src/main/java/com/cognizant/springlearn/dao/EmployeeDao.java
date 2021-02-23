package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.Employee;

@Component
public class EmployeeDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

	private static ArrayList<Employee> EMPLOYEE_LIST;

	public static ArrayList<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}

	public static void setEMPLOYEE_LIST(ArrayList<Employee> eMPLOYEE_LIST) {
		EMPLOYEE_LIST = eMPLOYEE_LIST;
	} 
	
	public EmployeeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		setEMPLOYEE_LIST((ArrayList<Employee>)context.getBean("employeeList", ArrayList.class));
		LOGGER.debug("EmployeesDao {} :" +getAllEmployees());
	}
}
