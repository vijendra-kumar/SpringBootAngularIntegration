package com.javasampleapproach.restful.controller;
import com.javasampleapproach.restful.model.Customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class WebController {

	@Autowired
	private EmployeeService empService;	
	
	@GetMapping(value="/emp")
	public List<Customer> getAll(){
		System.out.println("calling get all emps");
		System.out.println(empService.getAllEmployees().size());
		return empService.getAllEmployees();
		
	}
	
	@GetMapping(value="/emp/{id}")
	public Optional<Customer> getCustomer(@PathVariable Integer id){
		System.out.println("calling get one");
		return empService.getEmployee(id);
	}
	
	@PostMapping(value="/emp")
	public Customer postCustomer(@RequestBody Customer customer){
		System.out.println("calling add/post");
		customer.setId(empService.getAllEmployees().size()+1);
		return empService.addEmployee(customer);
	}
	
	@PutMapping(value="/emp/{id}")
	public void putCustomer(@RequestBody Customer customer, @PathVariable Integer id){
		System.out.println("calling updat/put");
		empService.updateEmployee(id, customer);
	}
	
	@DeleteMapping(value="/emp/{id}")
	public void deleteCustomer(@PathVariable Integer id){
		System.out.println("calling delete,,id is"+id);
		empService.deleteEmployee(id);
	}
}