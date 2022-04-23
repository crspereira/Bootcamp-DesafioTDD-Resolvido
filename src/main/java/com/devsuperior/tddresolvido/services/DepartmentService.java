package com.devsuperior.tddresolvido.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.tddresolvido.dto.DepartmentDTO;
import com.devsuperior.tddresolvido.entities.Department;
import com.devsuperior.tddresolvido.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<DepartmentDTO> findAll() {
		List<Department> departments = departmentRepository.findAll(Sort.by("name"));
		return departments.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
	}

}
