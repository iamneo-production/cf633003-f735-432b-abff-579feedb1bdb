package com.hackathon.userauthenticationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.userauthenticationservice.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer>{

	Optional<Patient> findByEmail(String email);
    
}
