package com.fs.springtests.app.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.springtests.app.dao.AppDao;
import com.fs.springtests.app.model.Employee;

 

@Service
public class AppService {

	@Autowired
	private AppDao appDao;
	
	public Double getMaxSalary() {
		
		
		List<Employee> emps=appDao.getEmployeeList();
		
	Employee em=	emps.stream().max(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		})
			.get();
		
	 return (em==null?0.0:em.getSalary());
		
	}
	
	
}
