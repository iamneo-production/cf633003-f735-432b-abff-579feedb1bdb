package com.hackathon.appointmentschedularservice.dto;
import java.time.LocalDate;

public class AppointmentStatus {
    private int appointmentId;
    private int patientId;
    private int providerId;
    private LocalDate date;
    private String time;
    private Status status;
    
    // Constructors
    public AppointmentStatus() {
    }
    
    public AppointmentStatus(int appointmentId, int patientId, int providerId, LocalDate date, String time, Status status) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.providerId = providerId;
        this.date = date;
        this.time = time;
        this.status = status;
    }
    
    // Getters and Setters
    public int getAppointmentId() {
        return appointmentId;
    }
    
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    
    public int getPatientId() {
        return patientId;
    }
    
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    
    public int getProviderId() {
        return providerId;
    }
    
    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public String getTime() {
        return time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    public Status getStatus() {
        return status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
    // Enum for Status
    public enum Status {
        SCHEDULED,
        CANCELED,
        COMPLETED
        // Add more status if needed
    }
}
