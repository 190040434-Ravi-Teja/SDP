package com.hospitalmanagementsystem.repository;



import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.hospitalmanagementsystem.model.Patient;


public interface PatientRepository extends CrudRepository<Patient,Long>{
	
	List<Patient> findByDiseaseName(String diseaseName);

}
