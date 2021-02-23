package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

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
		setEMPLOYEE_LIST((ArrayList<Employee>) context.getBean("employeeList", ArrayList.class));
		LOGGER.debug("EmployeesDao {} :" + getAllEmployees());
	}

	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
		LOGGER.info("START");
		for (Employee employeeInList : EMPLOYEE_LIST) {
			if (employeeInList.getId() == employee.getId()) {
				EMPLOYEE_LIST.remove(employeeInList);
				EMPLOYEE_LIST.add(employee);
				LOGGER.info("END");
				return;
			}
		}
		throw new EmployeeNotFoundException();
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		for(Employee emp : EMPLOYEE_LIST) {
			if(emp.getId() == id) {
				EMPLOYEE_LIST.remove(emp);
				return;
			}
		}
		throw new EmployeeNotFoundException();
	}
}
