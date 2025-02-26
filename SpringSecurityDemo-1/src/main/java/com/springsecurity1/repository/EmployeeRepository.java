package com.springsecurity1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity1.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	Employee findByUsername(String username);
	
}
