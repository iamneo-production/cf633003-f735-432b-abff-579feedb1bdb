package com.hackathon.appointmentschedularservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.appointmentschedularservice.dto.AppointmentStatus;
import com.hackathon.appointmentschedularservice.dto.Date;
import com.hackathon.appointmentschedularservice.externalservice.AppointmentstatusExternal;

@RestController
@RequestMapping("/appointments")
public class AppointmentSchedularController {
    @Autowired
    AppointmentstatusExternal appointmentstatusExternal;

    @PostMapping()
    public AppointmentStatus appointmentBook(@RequestBody Date date){
        System.out.println(date);
        
       return appointmentstatusExternal.getAppointmentStatus(date.getDate(),date.getTime());
    }

    
}
