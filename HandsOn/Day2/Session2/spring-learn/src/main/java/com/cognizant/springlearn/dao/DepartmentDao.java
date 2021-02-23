package com.cognizant.springlearn.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.Department;

@Component
public class DepartmentDao {

	private static List<Department> DEPARTMENT_LIST;

	public static List<Department> getAllDepartments() {
		return DEPARTMENT_LIST;
	}

	public static void setDEPARTMENT_LIST(List<Department> dEPARTMENT_LIST) {
		DEPARTMENT_LIST = dEPARTMENT_LIST;
	}
	
	public DepartmentDao() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("employee.xml");
		setDEPARTMENT_LIST((List<Department>) context.getBean("departmentList"));
	}
	
}
