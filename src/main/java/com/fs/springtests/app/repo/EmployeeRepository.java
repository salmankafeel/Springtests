package com.fs.springtests.app.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fs.springtests.app.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
}
