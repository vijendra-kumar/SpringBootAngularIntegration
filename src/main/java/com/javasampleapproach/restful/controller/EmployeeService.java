package com.javasampleapproach.restful.controller;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.restful.model.Customer;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDatabase empDatabase;

	public List<Customer> getAllEmployees(){
		List<Customer> emps = new ArrayList<>();
		empDatabase.findAll().forEach(emps::add);
		return emps;
	}
	public Optional<Customer> getEmployee(Integer id) {
		//return emps.stream().filter(t -> t.getName().equals(id)).findFirst().get();
		return empDatabase.findById(id);
	}
	public Customer addEmployee(Customer em) {
		return empDatabase.save(em);
	}
	public void updateEmployee(Integer id, Customer emp) {
		empDatabase.save(emp);

	}
	public void deleteEmployee(Integer id) {
		System.out.println("id entry is there --"+ empDatabase.existsById(id));
		System.out.println("no of enteries in db:"+getAllEmployees().size());
		empDatabase.deleteById(id);
		System.out.println("no of enteries in db:"+getAllEmployees().size());
	}
	}
