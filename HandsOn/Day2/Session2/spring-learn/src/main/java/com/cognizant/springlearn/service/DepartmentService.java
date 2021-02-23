package com.cognizant.springlearn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Department;
import com.cognizant.springlearn.dao.DepartmentDao;

@Service
public class DepartmentService {
	
	@Transactional
	public List<Department> getAllDepartments(){
		return DepartmentDao.getAllDepartments();
	}
}
