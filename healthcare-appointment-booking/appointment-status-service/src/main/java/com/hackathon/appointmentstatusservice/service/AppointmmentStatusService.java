package com.hackathon.appointmentstatusservice.service;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.appointmentstatusservice.entity.AppointmentStatus;
import com.hackathon.appointmentstatusservice.entity.Status;
import com.hackathon.appointmentstatusservice.exception.DataNotFoundException;
import com.hackathon.appointmentstatusservice.repository.AppointmentStatusRepo;

@Service
public class AppointmmentStatusService {
    
    @Autowired
    AppointmentStatusRepo appointmentStatusRepo;

    public AppointmentStatus saveApponintment(AppointmentStatus appointmentStatus){
        return appointmentStatusRepo.save(appointmentStatus);
    }

    public List<AppointmentStatus> getAppointmentStatusByDateTime(Date date, String time){
        Optional<List<AppointmentStatus>> appointList = appointmentStatusRepo.findAllByDate(date);
        Optional<AppointmentStatus> appointmentStatus;
        List<AppointmentStatus> appointmentStatusList= new ArrayList<>();
        if(appointList.isPresent()){
        	if(!appointList.get().isEmpty()) {
            appointmentStatus = appointList.get().stream().filter(x->x.getTime().equals(time)).findAny();
	            if(appointmentStatus.isPresent()){
	                appointmentStatus.get().setStatus(Status.BOOKED);
	                appointmentStatusList.add(appointmentStatusRepo.save(appointmentStatus.get()));
	                return appointmentStatusList;
	            } 	
            } 
         }    
        Optional<List<AppointmentStatus>> availbaleAppointment = appointmentStatusRepo.findAllByStatus(Status.AVAILABLE);
        if (availbaleAppointment.isPresent()) {
        	if(!availbaleAppointment.get().isEmpty()) {
            return availbaleAppointment.get();}
        }    
   	 throw new DataNotFoundException("All Slots Booked");
    }
    
    public AppointmentStatus getAppointmentByIds(Integer patientId, Integer healthcareProiderId) {
		Optional<List<AppointmentStatus>> appointList = appointmentStatusRepo.findAllByPatientId(patientId);
		Optional<AppointmentStatus> appointmentStatus;
        if(appointList.isPresent()){
            appointmentStatus = appointList.get().stream().filter(x->x.getProviderId()==(healthcareProiderId)).findAny();
            if(appointmentStatus.isPresent()){
                return appointmentStatus.get();
            }
            else {
				throw new DataNotFoundException("PatientId & ProviderId is Invalid");
			}
        }
		throw new DataNotFoundException("PatientId & ProviderId is Invalid");
	}
    
    public AppointmentStatus getById(int id) {
    	Optional<AppointmentStatus> o=appointmentStatusRepo.findById(id);
    	if(o.isPresent()) {
    		return o.get();
    	}
    	throw new  DataNotFoundException("Appointment Id Not Found");
    }
    public AppointmentStatus changeCompletedStatus(Integer id) {
    	AppointmentStatus appointmentStatus = this.getById(id);
    	appointmentStatus.setStatus(Status.COMPLETED);
    	return appointmentStatusRepo.save(appointmentStatus);
   }
    
}
