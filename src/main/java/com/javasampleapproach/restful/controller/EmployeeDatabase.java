package com.javasampleapproach.restful.controller;


import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.restful.model.Customer;

public interface EmployeeDatabase extends CrudRepository<Customer, Integer> {


}
