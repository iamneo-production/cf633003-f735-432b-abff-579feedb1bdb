package com.hackathon.appointmentstatusservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.appointmentstatusservice.entity.AppointmentStatus;
import com.hackathon.appointmentstatusservice.entity.Status;
import com.hackathon.appointmentstatusservice.repository.AppointmentStatusRepo;

@Service
public class AppointmmentStatusService {
    
    @Autowired
    AppointmentStatusRepo appointmentStatusRepo;

    public AppointmentStatus saveApponintment(AppointmentStatus appointmentStatus){
        return appointmentStatusRepo.save(appointmentStatus);
    }

    public AppointmentStatus getAppointmentStatus(Integer id) {
        return appointmentStatusRepo.findById(id).get();
    }

    public AppointmentStatus getAppointmentStatusByDateTime(LocalDate date, String time){
        Optional<List<AppointmentStatus>> appointList = appointmentStatusRepo.findAllByDate(date);
        Optional<AppointmentStatus> appointmentStatus;
        if(appointList.isPresent()){
            appointmentStatus = appointList.get().stream().filter(x->x.getTime().equals(time)).findAny();
            if(appointmentStatus.isPresent()){
                appointmentStatus.get().setStatus(Status.BOOKED);
                return appointmentStatusRepo.save(appointmentStatus.get());
            }
            else{
                return AppointmentStatus.builder()
                .appointmentId(999)
                .patientId(999)
                .build();
            }
        }
        return AppointmentStatus.builder()
                .appointmentId(888)
                .patientId(888)
                .build();
    }
}
