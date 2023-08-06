package com.hackathon.appointmentschedularservice.dto;
import java.sql.Date;

public class AppointmentStatus {
    private int appointmentId;
    private int patientId;
    private int providerId;
    private Date date;
    private String time;
    private Status status;
    
    public AppointmentStatus() {
    }
    
    public AppointmentStatus(int appointmentId, int patientId, int providerId, Date date, String time, Status status) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.providerId = providerId;
        this.date = date;
        this.time = time;
        this.status = status;
    }
    
 
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
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
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
    
   
}
