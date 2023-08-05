package com.hackathon.userauthenticationservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.userauthenticationservice.dto.AuthResponse;
import com.hackathon.userauthenticationservice.entity.HealthcareProvider;
import com.hackathon.userauthenticationservice.entity.Patient;
import com.hackathon.userauthenticationservice.entity.UserCredential;
import com.hackathon.userauthenticationservice.exception.DuplicateException;
import com.hackathon.userauthenticationservice.repository.HealthcareProviderRepository;
import com.hackathon.userauthenticationservice.repository.PatientRepository;
import com.hackathon.userauthenticationservice.repository.UserCredentialRepository;

@Service
public class AuthService {
    
    Logger log = LoggerFactory.getLogger(AuthService.class);
    // @Autowired 
	// Environment env;
    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private HealthcareProviderRepository healthcareProviderRepository;
    @Autowired
    private PatientRepository patientRepository;
    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;
    
    public String savePatient(Patient patient) {
        Optional<Patient> existingPatient = patientRepository.findByEmail(patient.getEmail());
        if (existingPatient.isPresent()) {
            log.error("Email Already Present In System "+ patient.getEmail());
            throw new DuplicateException("Email Already Present In System ");
        }
        // patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        patient = patientRepository.save(patient);
         log.info("Patient saved with email"+ patient.getEmail());
        UserCredential user=new UserCredential();
        user.setEmail(patient.getEmail());
        user.setName(patient.getName());
        user.setPassword(patient.getPassword());
        this.saveUser(user);
        return "user added to the system";
	}

     public String saveHealthcareProvider(HealthcareProvider healthcareprovider) {
        Optional<HealthcareProvider> existingHealthcareProvider = healthcareProviderRepository.findByEmail(healthcareprovider.getEmail());
        if (existingHealthcareProvider.isPresent()) {
            log.error("Email Already Present In System "+ healthcareprovider.getEmail());
            throw new DuplicateException("Email Already Present In System ");
        }
        // healthcareprovider.setPassword(passwordEncoder.encode(healthcareprovider.getPassword()));
        healthcareprovider = healthcareProviderRepository.save(healthcareprovider);
        log.info("Health Care Provider saved with email"+ healthcareprovider.getEmail());
        UserCredential user=new UserCredential();
        user.setEmail(healthcareprovider.getEmail());
        user.setName(healthcareprovider.getName());
        user.setPassword(healthcareprovider.getPassword());
        this.saveUser(user);
        return "user added to the system";
	}
    
    public void saveUser(UserCredential credential) {
        // credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        repository.save(credential);
        log.info("User saved with email"+ credential.getEmail());
    }
     public AuthResponse authResponseToken(String username) {
        return new AuthResponse(username,jwtService.generateToken(username));
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        // if(!jwtService.validateToken(token)){
        //     throw new DataNotFoundException("Invalid Token");
        // }
        jwtService.validateToken(token);
    }
}
