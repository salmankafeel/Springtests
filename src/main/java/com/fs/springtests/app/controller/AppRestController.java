package com.fs.springtests.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fs.springtests.app.model.Employee;
import com.fs.springtests.app.service.AppService;

@RestController
public class AppRestController {

	
	@Autowired
	private AppService appService;
	
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET )
	public List<Employee> getAllEmployees() {
		
		List<Employee> emps=appService.getEmployeeList();
		
		return emps;
	}
	
	
	
	@PostMapping("/updateEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		
		Employee emp= appService.createOrUpdateEmployee(employee);
		return emp;
	}
	
	
	@GetMapping("/retrieveEmployee/{employeeId}")
	public Employee retrieveEmployee(@PathVariable String employeeId) {
		
		if(employeeId==null) {
			throw new RuntimeException("Employee id is required");
		}
		
		return  appService.getEmployeById(employeeId);
		
	}
	
	@GetMapping("/deleteEmployee/{employeeId}")
	public String deleteEmployee(@PathVariable String employeeId) {
		
		if(employeeId==null) {
			throw new RuntimeException("Employee id is required to delete");
		}
	
		  appService.deleteEmployee(employeeId);
		return employeeId;
		
	}
	
	
	
}
