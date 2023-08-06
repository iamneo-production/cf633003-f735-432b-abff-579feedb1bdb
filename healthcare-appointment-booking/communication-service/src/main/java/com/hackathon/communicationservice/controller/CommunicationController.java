package com.hackathon.communicationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.hackathon.communicationservice.service.CommunicationService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/notifications")
public class CommunicationController {
    	
	@Autowired
	CommunicationService communicationService;
	
	@PostMapping("/{patientId}/{healtcareProvideId}")
	@CircuitBreaker(name="getAppointmentStatus",fallbackMethod = "getAppointmentStatusNotFound")
	public ResponseEntity<?> getAppointmentStatus(@PathVariable Integer patientId, @PathVariable Integer healtcareProvideId) {
		return new ResponseEntity<>( communicationService.getAppointmentStatus(patientId, healtcareProvideId),HttpStatus.OK);
	}
	
	//Fallback
	public ResponseEntity<?> getAppointmentStatusNotFound(Integer patientId, Integer healtcareProvideId,Exception e)  {
		return new ResponseEntity<>( "Data Not Found",HttpStatus.NOT_FOUND);
	}
	
}
