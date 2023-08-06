package com.hackathon.paymentsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.*;

import com.hackathon.paymentsservice.dto.AppointmentStatus;
import com.hackathon.paymentsservice.entity.Payment;
import com.hackathon.paymentsservice.entity.Status;
import com.hackathon.paymentsservice.exception.DataNotFoundException;
import com.hackathon.paymentsservice.externalservices.AppointmentstatusExternal;
import com.hackathon.paymentsservice.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    
    @Autowired
    AppointmentstatusExternal appointmentstatusExternal;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @PostMapping()
    public ResponseEntity<Payment> savePayment1(@RequestBody Payment payment){
        payment.setTimestamp(LocalDateTime.now());
        payment.setStatus(Status.PAID);
        Payment payment1=paymentService.savePayment(payment);
        AppointmentStatus appointmentstatu= appointmentstatusExternal.changeCompletedStatus(payment.getAppointmentId());
        if(payment.getPatientId()==appointmentstatu.getPatientId()&&payment.getAppointmentId()==appointmentstatu.getAppointmentId())
        	return new ResponseEntity<Payment>(payment1,HttpStatus.CREATED);
        throw new DataNotFoundException("Wrong AppointmentId or PatientId");
    }
    @GetMapping()
    public ResponseEntity<List<Payment>> getAll1(){
        List<Payment> list=paymentService.getAll();
        return new ResponseEntity<List<Payment>>(list,HttpStatus.OK);

    }

    @GetMapping("/payementId/{id}")
    public ResponseEntity<Payment> getByPaymentId1(@PathVariable int id){
        Payment payment= paymentService.getByPaymentId(id);
        return new ResponseEntity<Payment>(payment, HttpStatus.OK);
    }

     @GetMapping("/getByAppointmentId/{id}")
    public ResponseEntity<Payment> getByAppointmentId1(@PathVariable int id){
        Payment payment= paymentService.getByAppointmentId(id);
        return new ResponseEntity<Payment>(payment, HttpStatus.OK);
    }
     @GetMapping("/getByPatientId/{id}")
    public ResponseEntity<Payment> getByPatientId1(@PathVariable int id){
        Payment payment= paymentService.getByPatientId(id);
        return new ResponseEntity<Payment>(payment, HttpStatus.OK);
    }
    
}
