package com.hackathon.communicationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Communication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int communicationId;
    private int patientId;
    private int healthcareProviderId;
    private int appointmentId;
	public int getCommunicationId() {
		return communicationId;
	}
	public void setCommunicationId(int communicationId) {
		this.communicationId = communicationId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getHealthcareProviderId() {
		return healthcareProviderId;
	}
	public void setHealthcareProviderId(int healthcareProviderId) {
		this.healthcareProviderId = healthcareProviderId;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Communication(int communicationId, int patientId, int healthcareProviderId, int appointmentId) {
		super();
		this.communicationId = communicationId;
		this.patientId = patientId;
		this.healthcareProviderId = healthcareProviderId;
		this.appointmentId = appointmentId;
	}
	public Communication() {}
	@Override
	public String toString() {
		return "Communication [communicationId=" + communicationId + ", patientId=" + patientId
				+ ", healthcareProviderId=" + healthcareProviderId + ", appointmentId=" + appointmentId + "]";
	}
}
