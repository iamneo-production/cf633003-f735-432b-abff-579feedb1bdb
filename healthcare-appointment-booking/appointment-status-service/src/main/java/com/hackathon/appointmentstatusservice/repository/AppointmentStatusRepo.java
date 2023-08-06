package com.hackathon.appointmentstatusservice.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.appointmentstatusservice.entity.AppointmentStatus;

@Repository
public interface AppointmentStatusRepo extends JpaRepository<AppointmentStatus,Integer> {

	Optional<List<AppointmentStatus>> findAllByDate(LocalDate date);
    
}
