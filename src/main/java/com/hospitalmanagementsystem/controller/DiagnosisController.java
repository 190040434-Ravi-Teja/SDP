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
import com.hospitalmanagementsystem.model.Diagnosis;
import com.hospitalmanagementsystem.model.Patient;
import com.hospitalmanagementsystem.repository.DiagnosisRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DiagnosisController {

	private Logger log = LoggerFactory.getLogger(DiagnosisController.class);
	 
	@Autowired
	DiagnosisRepository diagnosisRepository;

	@PostMapping(value = "/diagnosiss")
	  public ResponseEntity<Diagnosis> postDiagnosis(@RequestBody Diagnosis diagnosis) {
	    try {
	        log.info("Inside Post Diagnosis");
	      Diagnosis _diagnosis = diagnosisRepository.save(new Diagnosis(diagnosis.getPatientId(), diagnosis.getName(), diagnosis.getAdministeredBy(), 
	    		  diagnosis.getBillAmount(), diagnosis.getPaymentMode()));
	      return new ResponseEntity<>(_diagnosis, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	
	 @GetMapping("/diagnosiss")
	  public ResponseEntity<List<Diagnosis>> getAllDiagnosiss() {
	    List<Diagnosis> diagnosiss = new ArrayList<Diagnosis>();
	    try {
	    	diagnosisRepository.findAll().forEach(diagnosiss::add);
	     
	      if (diagnosiss.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(diagnosiss, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 @GetMapping("/diagnosiss/{id}")
	  public ResponseEntity<Diagnosis> getDiagnosisById(@PathVariable("id") long id) throws ResourceNotFoundException{
		 Diagnosis diagnosisData = diagnosisRepository.findById(id)
				    .orElseThrow(() -> new ResourceNotFoundException("Diagnosis not found for this id :: " +id));

				    return ResponseEntity.ok().body(diagnosisData);
		
		 
	   /* Optional<Diagnosis> diagnosisData = diagnosisRepository.findById(id);

	    if (diagnosisData.isPresent()) {
	      return new ResponseEntity<>(diagnosisData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    } */
	  }
	 
	 @PutMapping(value = "/diagnosiss/update")
	  public Diagnosis updateDiagnosis(@RequestBody Diagnosis diagnosis) {
	      System.out.println("Into update");
	    System.out.println("into update"+diagnosis.getId()+" "+diagnosis.getName());
	    Diagnosis diagnosis1 = diagnosisRepository.save(new Diagnosis(diagnosis.getId(),diagnosis.getPatientId(),diagnosis.getName(), diagnosis.getAdministeredBy(), diagnosis.getBillAmount(), diagnosis.getPaymentMode() ));
	    return diagnosis1;
	  }
	 
	 @DeleteMapping("/diagnosiss/{id}")
	  public ResponseEntity<HttpStatus> deleteDiagnosis(@PathVariable("id") long id) {
	    try {
	    	diagnosisRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }


}
