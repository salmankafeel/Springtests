package com.fs.springtests.app.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.springtests.app.model.Employee;
import com.fs.springtests.app.repo.EmployeeRepository;

 

@Service
public class AppService {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	public Double getMaxSalary() {
		
		
		List<Employee> emps=employeeRepo.findAll();
		
	Employee em=	emps.stream().max(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		})
			.get();
		
	 return (em==null?0.0:em.getSalary());
		
	}

	public List<Employee> getEmployeeList() {
		
		System.out.println("total count : "+employeeRepo.count());
		return employeeRepo.findAll();
		
	}

	public Employee createOrUpdateEmployee(Employee employee) {
		
		return employeeRepo.save(employee);
	}

	public Employee getEmployeById(String employeeId) {
		return employeeRepo.getOne(Long.parseLong(employeeId));
	}

	public void deleteEmployee(String employeeId) {
		employeeRepo.deleteById(Long.parseLong(employeeId));
	}
	
	
}
