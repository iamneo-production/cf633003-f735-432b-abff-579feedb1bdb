package com.hackathon.paymentsservice.externalservices;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.hackathon.paymentsservice.dto.AppointmentStatus;



@FeignClient("Appointment-Status-Service")
public interface AppointmentstatusExternal {
	@GetMapping("appointments/changeStatusCompleted/{id}")
	public AppointmentStatus changeCompletedStatus(@PathVariable int id);

	
}
