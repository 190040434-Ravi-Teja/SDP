package com.hospitalmanagementsystem.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.hospitalmanagementsystem.model.Patient;
import com.hospitalmanagementsystem.model.Physician;
import com.hospitalmanagementsystem.repository.PatientRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PatientController {
	
	private Logger log = LoggerFactory.getLogger(PatientController.class);
	 
	@Autowired
	PatientRepository patientRepository;

	@PostMapping(value = "/patients")
	  public ResponseEntity<Patient> postPatient(@RequestBody Patient patient) {
	    try {
	        log.info("Inside Post Patient");
	        Patient _patient = patientRepository.save(new Patient(patient.getFirstName(), patient.getLastName(), patient.getAge(), patient.getDiseaseName(), patient.getPhone(), patient.getGender()));
	      return new ResponseEntity<>(_patient, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	
	 @GetMapping("/patients")
	  public ResponseEntity<List<Patient>> getAllPatients() {
	    List<Patient> patients = new ArrayList<Patient>();
	    try {
	    	patientRepository.findAll().forEach(patients::add);
	     
	      if (patients.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(patients, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 @GetMapping("/patients/{id}")
	  public ResponseEntity<Patient> getPatientById(@PathVariable("id") long id) throws ResourceNotFoundException{
		 Patient patientData = patientRepository.findById(id)
				    .orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " +id));

				    return ResponseEntity.ok().body(patientData);
		 
		 
	   /* Optional<Patient> patientData = patientRepository.findById(id);

	    if (patientData.isPresent()) {
	      return new ResponseEntity<>(patientData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    } */
	  }
	 
	 @PutMapping(value = "/patients/update")
	  public Patient updatePatient(@RequestBody Patient patient) {
	      System.out.println("Into update");
	    System.out.println("into update"+patient.getId()+" "+patient.getFirstName());
	    Patient patient1 = patientRepository.save(new Patient(patient.getId(),patient.getFirstName(), patient.getLastName(), patient.getAge(), patient.getDiseaseName(), patient.getPhone(), patient.getGender()));
	    return patient1;
	  }
	 
	 @DeleteMapping("/patients/{id}")
	  public ResponseEntity<HttpStatus> deletePatient(@PathVariable("id") long id) {
	    try {
	    	patientRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	 
	 @GetMapping(value = "patients/diseaseName/{diseaseName}")
	  public ResponseEntity<List<Patient>> findByDiseaseName(@PathVariable String diseaseName) {
	    try {
	      List<Patient> patients = patientRepository.findByDiseaseName(diseaseName);

	      if (patients.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(patients, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	 
}
