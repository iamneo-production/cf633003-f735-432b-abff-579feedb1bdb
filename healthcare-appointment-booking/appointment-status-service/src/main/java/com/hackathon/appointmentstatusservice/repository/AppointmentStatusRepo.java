package com.hackathon.appointmentstatusservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.appointmentstatusservice.entity.AppointmentStatus;
@Repository
public interface AppointmentStatusRepo extends JpaRepository<AppointmentStatus,Integer> {
    
}
