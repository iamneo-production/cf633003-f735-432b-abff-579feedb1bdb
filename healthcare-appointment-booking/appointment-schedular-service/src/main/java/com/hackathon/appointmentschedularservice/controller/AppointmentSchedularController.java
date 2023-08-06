package com.hackathon.appointmentschedularservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.appointmentschedularservice.dto.AppointmentStatus;
import com.hackathon.appointmentschedularservice.dto.Date1;
import com.hackathon.appointmentschedularservice.externalservice.AppointmentstatusExternal;

@RestController
@RequestMapping("/appointments")
public class AppointmentSchedularController {
    @Autowired
    AppointmentstatusExternal appointmentstatusExternal;

    @PostMapping()
    public List<AppointmentStatus> appointmentBook(@RequestBody Date1 date){   
       return appointmentstatusExternal.getAppointmentStatus(date.getDate(),date.getTime());
    }

    
}
