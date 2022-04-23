package com.devsuperior.tddresolvido.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.tddresolvido.dto.EmployeeDTO;
import com.devsuperior.tddresolvido.entities.Department;
import com.devsuperior.tddresolvido.entities.Employee;
import com.devsuperior.tddresolvido.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional(readOnly = true)
	public Page<EmployeeDTO> findAllPaged(Pageable pageable) {
		Page<Employee> employees = (Page<Employee>) employeeRepository.findAll(pageable);
		return employees.map(x -> new EmployeeDTO(x));
	}
	
	@Transactional
	public EmployeeDTO insert(EmployeeDTO employeeDto) {
		Employee employee = new Employee();
		employee.setName(employeeDto.getName());
		employee.setEmail(employeeDto.getEmail());
		employee.setDepartment(new Department(employeeDto.getDepartmentId(), null));
		
		employeeRepository.save(employee);
		
		return new EmployeeDTO(employee);
	}

}
