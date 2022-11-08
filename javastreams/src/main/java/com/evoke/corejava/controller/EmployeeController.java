package com.evoke.corejava.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.evoke.corejava.model.Employee;

@RestController
public class EmployeeController {
	@GetMapping(value = "/employee")
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(60000);

		return emp;
	}
}
