package com.parmodarora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parmodarora.domain.Employee;
import com.parmodarora.domain.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		return this.employeeRepository.findAll();
	}

	@Override
	public void add(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return this.employeeRepository.findOne(id);
	}

}
