package com.hackathon.appointmentschedularservice.externalservice;


import java.sql.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hackathon.appointmentschedularservice.dto.AppointmentStatus;

@FeignClient("Appointment-Status-Service")
public interface AppointmentstatusExternal {
    @PostMapping("/appointments/status/{date}/{time}")
    public List<AppointmentStatus> getAppointmentStatus(@PathVariable Date date,@PathVariable String time);

    
}
