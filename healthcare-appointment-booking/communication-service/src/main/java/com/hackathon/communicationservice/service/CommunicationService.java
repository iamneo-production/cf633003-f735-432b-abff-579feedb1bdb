package com.hackathon.communicationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.communicationservice.dto.AppointmentStatus;
import com.hackathon.communicationservice.externalservice.AppointmentStatusService;
import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;

@Service
public class CommunicationService {
	
	@Autowired
	AppointmentStatusService appointmentStatusService;
	
	
	public AppointmentStatus getAppointmentStatus(Integer patientId, Integer healtcareProvideId) {
		return appointmentStatusService.getAppointmentStatusByIds(patientId, healtcareProvideId);
	}
	
}
