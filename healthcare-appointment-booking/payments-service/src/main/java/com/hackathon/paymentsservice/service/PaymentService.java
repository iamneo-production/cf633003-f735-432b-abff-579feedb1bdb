package com.hackathon.paymentsservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.paymentsservice.entity.Payment;
import com.hackathon.paymentsservice.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;


    public Payment savePayment(Payment payment){
        return paymentRepository.save(payment);
    }

    public List<Payment> getAll(){
        return paymentRepository.findAll();
    }

    public Payment getByPaymentId(int id){
        return paymentRepository.findById(id).get();
    }

    public Payment getByPatientId(int id){
         return paymentRepository.findByPatientId(id).get();
    }

    public Payment getByAppointmentId(int id){
         return paymentRepository.findByAppointmentId(id).get();
    }
    
    
}
