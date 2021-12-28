package com.hospitalmanagementsystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hospitalmanagementsystem.model.Physician;

public interface PhysicianRepository extends CrudRepository<Physician,Long>{
	
	List<Physician> findByDepartment(String department);
}
