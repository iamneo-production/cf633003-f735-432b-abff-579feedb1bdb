package com.hackathon.communicationservice.externalservice;

import org.springframework.cloud.openfeign.FeignClient;

import com.hackathon.communicationservice.dto.AppointmentStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="Appointment-Status-Service")
public interface AppointmentStatusService {
	
	@GetMapping("appointments/getappointment/{patientId}/{healtcareProviderId}")
	AppointmentStatus getAppointmentStatusByIds(@PathVariable Integer patientId,@PathVariable Integer healtcareProviderId);
}
