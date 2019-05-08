package com.fs.springtests.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="empnumber")
	private String empNumber;
	@Column(name ="name")
	private String name;
	@Column(name ="address")
	private String address;
	@Column(name ="salary")
	private Double salary;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Employee(Long id, String empNumber, String name, String address, Double salary) {
		super();
		this.id = id;
		this.empNumber = empNumber;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	public String getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empNumber=" + empNumber + ", name=" + name + ", address=" + address
				+ ", salary=" + salary + "]";
	}
	
	
	
}
