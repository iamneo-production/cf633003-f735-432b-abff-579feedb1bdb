package com.hackathon.userauthenticationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.userauthenticationservice.entity.HealthcareProvider;

@Repository
public interface HealthcareProviderRepository extends JpaRepository<HealthcareProvider,Integer>{
    Optional<HealthcareProvider> findByEmail(String email);
}
