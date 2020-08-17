package com.main.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.app.model.Employee;

@RestController
public class EmployeeController {

	
	@RequestMapping("/emp")
	public Employee firstPage() {
		Employee emp=new Employee();
		emp.setName("shivansh");
		emp.setDesg("se");
		emp.setEmpId("emp1");
		emp.setSalary("12000");
		
		return emp;
	}
}
