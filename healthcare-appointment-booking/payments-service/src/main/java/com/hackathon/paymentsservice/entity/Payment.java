package com.hackathon.paymentsservice.entity;
import java.time.LocalDateTime;

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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    private int patientId;
    private int appointmentId;
    private double amount;
    private Status status;
    private LocalDateTime timestamp;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public Payment(int paymentId, int patientId, int appointmentId, double amount, Status status,
			LocalDateTime timestamp) {
		super();
		this.paymentId = paymentId;
		this.patientId = patientId;
		this.appointmentId = appointmentId;
		this.amount = amount;
		this.status = status;
		this.timestamp = timestamp;
	}
	public Payment() {}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", patientId=" + patientId + ", appointmentId=" + appointmentId
				+ ", amount=" + amount + ", status=" + status + ", timestamp=" + timestamp + "]";
	}

}
