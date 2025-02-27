package com.devsuperior.tddresolvido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.tddresolvido.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
