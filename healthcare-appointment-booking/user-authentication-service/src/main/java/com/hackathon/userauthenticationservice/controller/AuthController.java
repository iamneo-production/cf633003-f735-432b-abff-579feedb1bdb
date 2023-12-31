package com.hackathon.userauthenticationservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.hackathon.userauthenticationservice.dto.AuthRequest;
import com.hackathon.userauthenticationservice.entity.HealthcareProvider;
import com.hackathon.userauthenticationservice.entity.Patient;
import com.hackathon.userauthenticationservice.exception.DataNotFoundException;
import com.hackathon.userauthenticationservice.service.AuthService;

@RestController
@RequestMapping("/users")
public class AuthController {

    Logger log = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private AuthService service;

    @Autowired
    private AuthenticationManager authenticationManager;

     @GetMapping("/home")
    public String home() {
        return "user auth home";
    }
    @PostMapping("/register")
    public ResponseEntity<?> addNewUser(@RequestBody Patient patient) {
        return new  ResponseEntity<>(service.savePatient(patient),HttpStatus.OK);
    }
     @PostMapping("/register/healthcareprovider")
    public ResponseEntity<?> addNewHealthcareProvider(@RequestBody HealthcareProvider healthcareprovider) {
        return new  ResponseEntity<>( service.saveHealthcareProvider(healthcareprovider),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> getToken(@RequestBody AuthRequest authRequest) {

        try{
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
             return new  ResponseEntity<String>(service.generateToken(authRequest.getUsername()),HttpStatus.ACCEPTED);

        } else {
            log.error("Invalid Access");
            throw new DataNotFoundException("invalid access");
        }
        }
        catch(Exception e){
            log.info(e.getMessage());
        }
        throw new DataNotFoundException("invalid access");
        
    }

    @GetMapping("/validate")
    public Boolean validateToken(@RequestHeader(name = "Authorization" ) String tokenDup) {
        String token= tokenDup.substring(7);
        return  service.validateToken(token);
    }
}
