package com.devsuperior.tddresolvido.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.tddresolvido.dto.EmployeeDTO;
import com.devsuperior.tddresolvido.services.EmployeeService;

@RestController
@RequestMapping(value = "employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<Page<EmployeeDTO>> findAll(@PageableDefault(sort = "name") Pageable pageable) {
		Page<EmployeeDTO> list = employeeService.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}

}