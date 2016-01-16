package com.parmodarora.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.parmodarora.domain.Employee;
import com.parmodarora.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String employees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		model.addAttribute("employee", new Employee());
		return "home";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Employee employee) {
		employeeService.add(employee);
		return "redirect:/employee";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String employe(@PathVariable String id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(Long.valueOf(id)));
		return "employee";
	}

}
