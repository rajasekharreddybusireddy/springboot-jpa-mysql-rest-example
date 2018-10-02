package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping(value="/rest/employee/")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping(value="/all",method=RequestMethod.GET,produces="application/json")
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
		
	}
	@RequestMapping(value="/save",method=RequestMethod.POST,consumes="application/json")
	public List<Employee> save(@RequestBody final Employee employee){
		employeeRepository.save(employee);
		return employeeRepository.findAll();
		
	}
}
