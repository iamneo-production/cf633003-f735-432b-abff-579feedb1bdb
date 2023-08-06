package com.hackathon.communicationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.communicationservice.dto.AppointmentStatus;
import com.hackathon.communicationservice.externalservice.AppointmentStatusService;


@Service
public class CommunicationService {
	
	@Autowired
	AppointmentStatusService appointmentStatusService;
	
	
	public AppointmentStatus getAppointmentStatus(Integer patientId, Integer healtcareProvideId) {
		return appointmentStatusService.getAppointmentStatusByIds(patientId, healtcareProvideId);
	}
	

	
}
