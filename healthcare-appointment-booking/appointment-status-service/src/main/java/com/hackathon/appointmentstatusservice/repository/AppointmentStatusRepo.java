package com.hackathon.appointmentstatusservice.repository;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.appointmentstatusservice.entity.AppointmentStatus;
import com.hackathon.appointmentstatusservice.entity.Status;


@Repository
public interface AppointmentStatusRepo extends JpaRepository<AppointmentStatus,Integer> {

	Optional<List<AppointmentStatus>> findAllByDate(Date date);

	Optional<List<AppointmentStatus>> findAllByPatientId(Integer patientId);

	Optional<List<AppointmentStatus>> findAllByStatus(Status available);
	
	Optional<AppointmentStatus> findByPatientId(int patientId);
    
}
