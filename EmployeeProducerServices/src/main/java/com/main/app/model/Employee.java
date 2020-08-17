package com.main.app.model;

public class Employee {

	String empId;
	String name;
	String desg;
	String salary;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String empId, String name, String desg, String salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.desg = desg;
		this.salary = salary;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
}
