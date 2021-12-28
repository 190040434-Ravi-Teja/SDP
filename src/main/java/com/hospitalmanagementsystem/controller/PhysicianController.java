package com.hospitalmanagementsystem.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import com.hospitalmanagementsystem.model.Physician;

import com.hospitalmanagementsystem.repository.PhysicianRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PhysicianController {
	
	private Logger log = LoggerFactory.getLogger(PhysicianController.class);
	 
	@Autowired
	PhysicianRepository physicianRepository;

	@PostMapping(value = "/physicians")
	  public ResponseEntity<Physician> postPhysician(@Validated @RequestBody Physician physician) {
	    try {
	        log.info("Inside Post Physician");
	        Physician _physician = physicianRepository.save(new Physician(physician.getFirstName(), physician.getLastName(), physician.getDepartment(), physician.getQualification(), physician.getYearsOfExperience()));
	      return new ResponseEntity<>(_physician, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	
	 @GetMapping("/physicians")
	  public ResponseEntity<List<Physician>> getAllPhysicians() {
	    List<Physician> physicians = new ArrayList<Physician>();
	    try {
	      physicianRepository.findAll().forEach(physicians::add);
	     
	      if (physicians.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(physicians, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 @GetMapping("/physicians/{id}")
	  public ResponseEntity<Physician> getPhysicianById(@PathVariable("id") long id) throws ResourceNotFoundException{
	    Physician physicianData = physicianRepository.findById(id)
	    .orElseThrow(() -> new ResourceNotFoundException("Physician not found for this id :: " +id));

	    return ResponseEntity.ok().body(physicianData);
	    
	   /* Optional<Physician> physicianData = physicianRepository.findById(id);
	    if (physicianData.isPresent()) {
	      return new ResponseEntity<>(physicianData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    } */
	  }
	 
	 @PutMapping(value = "/physicians/update")
	  public Physician updatePhysician(@RequestBody Physician physician){
	      System.out.println("Into update");
	    System.out.println("into update"+physician.getId()+" "+physician.getFirstName());
	    Physician physician1 = physicianRepository.save(new Physician(physician.getId(), physician.getFirstName(), physician.getLastName(), physician.getDepartment(), physician.getQualification(), physician.getYearsOfExperience()));
	    return physician1;
	  }
	 
	 @DeleteMapping("/physicians/{id}")
	  public ResponseEntity<HttpStatus> deletePhysician(@PathVariable("id") long id) {
		  try {
	    	physicianRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    } 
	  }
	 
	 @GetMapping(value = "physicians/department/{department}")
	  public ResponseEntity<List<Physician>> findByDepartment(@PathVariable String department) {
	    try {
	      List<Physician> physicians = physicianRepository.findByDepartment(department);

	      if (physicians.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(physicians, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	
}
