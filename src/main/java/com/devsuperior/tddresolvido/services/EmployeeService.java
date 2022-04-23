package com.devsuperior.tddresolvido.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.tddresolvido.dto.EmployeeDTO;
import com.devsuperior.tddresolvido.entities.Employee;
import com.devsuperior.tddresolvido.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Page<EmployeeDTO> findAllPaged(Pageable pageable) {
		Page<Employee> employees = (Page<Employee>) employeeRepository.findAll(pageable);
		return employees.map(x -> new EmployeeDTO(x));
	}

}
