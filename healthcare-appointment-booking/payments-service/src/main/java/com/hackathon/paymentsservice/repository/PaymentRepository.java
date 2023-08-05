package com.hackathon.paymentsservice.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.paymentsservice.entity.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer>{

    Optional<Payment> findByPatientId(int patientId);

    Optional<Payment> findByAppointmentId(int appointmentId);
    
}
