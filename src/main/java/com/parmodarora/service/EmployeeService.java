package com.parmodarora.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parmodarora.domain.Employee;

@Service
@Transactional(readOnly=true)
public interface EmployeeService {

	public List<Employee> getAllEmployees();

	@Transactional(readOnly=false)
	public void add(Employee employee);

	public Employee getEmployeeById(Long valueOf);

}
