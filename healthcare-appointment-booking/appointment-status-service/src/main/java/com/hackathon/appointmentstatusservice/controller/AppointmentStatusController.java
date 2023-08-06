package com.hackathon.appointmentstatusservice.controller;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.appointmentstatusservice.entity.AppointmentStatus;
import com.hackathon.appointmentstatusservice.service.AppointmmentStatusService;

@RestController
@RequestMapping("/appointments")
public class AppointmentStatusController {

    @Autowired
    AppointmmentStatusService appointmmentStatusService;
    
    @GetMapping("/home")
    public String home(){
        return "Home";
    }
    
    @GetMapping("/{id}")
    public AppointmentStatus getAppointmentStatus(@PathVariable int id){
        return appointmmentStatusService.getById(id);
    }

    @PostMapping("/save")
    public AppointmentStatus savAppointmentStatus(@RequestBody AppointmentStatus appointmentStatus){
        return appointmmentStatusService.saveApponintment(appointmentStatus);
    }

    @PostMapping("/{date}/{time}")
    public List<AppointmentStatus> getAppointmentStatusByDateTime(@PathVariable Date date,@PathVariable String time){
        return appointmmentStatusService.getAppointmentStatusByDateTime(date,time);
    }
    
    
    @PostMapping("/status/{date}/{time}")
    public List<AppointmentStatus> getAppointmentStatusByDateTime1(@PathVariable Date date,@PathVariable String time){
        return appointmmentStatusService.getAppointmentStatusByDateTime(date,time);
    }
    
    
    @GetMapping("/getappointment/{patientId}/{healthcareProiderId}")
    public AppointmentStatus getAppoitmentByIds(@PathVariable Integer patientId,@PathVariable Integer healthcareProiderId){
        return appointmmentStatusService.getAppointmentByIds(patientId,healthcareProiderId);
    }
    
    @GetMapping("/changeStatusCompleted/{id}")
    public AppointmentStatus changeCompletedStatus(@PathVariable int id) {
    	return appointmmentStatusService.changeCompletedStatus(id);
    }
}
