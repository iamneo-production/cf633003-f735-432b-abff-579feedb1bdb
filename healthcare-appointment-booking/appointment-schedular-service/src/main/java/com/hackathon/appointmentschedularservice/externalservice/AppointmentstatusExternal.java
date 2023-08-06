package com.hackathon.appointmentschedularservice.externalservice;

import java.time.LocalDate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hackathon.appointmentschedularservice.dto.AppointmentStatus;

@FeignClient("Appointment-Status-Service")
public interface AppointmentstatusExternal {
    @PostMapping("/appointments/{date}/{time}")
    public AppointmentStatus getAppointmentStatus(@PathVariable LocalDate date,@PathVariable String time);

    
}
