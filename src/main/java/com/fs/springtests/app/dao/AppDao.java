package com.fs.springtests.app.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.fs.springtests.app.model.Employee;


@Repository
public class AppDao {

	
	public List<Employee> getEmployeeList() {
		
		List<Employee> emp=new ArrayList<>();
		  Employee ee= new Employee(98L,"" , "XXX", null, 2300.0);
		 
		
		Employee ee1= new Employee(92L,"" , "YYY", null, 76878.0);
		 
		emp.add(ee);
		emp.add(ee1);
		
		return emp;
		
	}
	
}
